package main.java.app;

import main.java.Database.Database;
import main.java.models.Question;
import main.java.models.User;
import main.java.socket.ClientHandler;
import main.java.socket.Responses;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class AppManager {
    private static String chet = "";
    public static final ArrayList<ClientHandler> CLIENT_HANDLERS = new ArrayList<>();
    public static final ArrayList<ClientHandler> CLIENT_HANDLERS_MULTIPLAYER = new ArrayList<>();
    public static final ArrayList<ClientHandler> CLIENT_HANDLERS_RESULT = new ArrayList<>();
    public static final ArrayList<User> EnteredUsers = new ArrayList<>();
    public static final ArrayList<User> MultiplayerUsers = new ArrayList<>();

    public static final ArrayList<Question> questionArray = new ArrayList<>();

    public static int userScore1 = 0;
    public static int userScore2 = 0;

    public static void addUser(User user) {
        EnteredUsers.add(user);
    }

    public static void addSocket(Socket socket) throws IOException {
        var clientHandler = new ClientHandler(socket);
        CLIENT_HANDLERS.add(clientHandler);
        clientHandler.start();
    }

    public static void addMessage(String name, String message) {
        chet += name + ": " + message + "\n";
    }

    public static void syncChet() {
        for (var clientHandler : CLIENT_HANDLERS)
            clientHandler.sendResponseStr(chet);
    }

    public static void findTheWinner() {
        String username1=MultiplayerUsers.get(0).username;
        String username2=MultiplayerUsers.get(1).username;

        if (userScore1 > userScore2)
            sendFinalDataToUsers(username1,userScore1,username2,userScore2);
        else
            sendFinalDataToUsers(username2,userScore2,username1,userScore1);
    }

    private static void sendFinalDataToUsers(String winnerName, int winneScorer, String loserName, int loserScore) {
        for (var clientHandlersResult : CLIENT_HANDLERS_RESULT) {
            clientHandlersResult.sendResponseStr(winnerName);
            clientHandlersResult.sendResponseInt(winneScorer);

            clientHandlersResult.sendResponseStr(loserName);
            clientHandlersResult.sendResponseInt(loserScore);
        }
    }

    public static void findTheQuestionsArray(String category) {
        ArrayList<Question> questions;
        switch (category) {
            case "English" -> questions = Database.SelectAllQuestions(1);
            case "Math" -> questions = Database.SelectAllQuestions(2);
            case "Food" -> questions = Database.SelectAllQuestions(3);
            case "Science" -> questions = Database.SelectAllQuestions(4);
            case "Common" -> questions = Database.SelectAllQuestions(5);
            default -> questions = Database.SelectAllQuestions(6);
        }

        for (int i = 0; i < 5; i++)
            questionArray.add(randomQuestion(questions));
    }

    public static void updateScores(String username, String isTrue, int index) {
        if (isTrue.equals(Responses.ACCEPT.response)) {
            if (MultiplayerUsers.get(0).username.equals(username))
                userScore1++;
            else
                userScore2++;
        }
        for (var clientHandlersMultiplayer : CLIENT_HANDLERS_MULTIPLAYER) {
            clientHandlersMultiplayer.sendResponseStr(username);
            clientHandlersMultiplayer.sendResponseStr(isTrue);
            clientHandlersMultiplayer.sendResponseInt(index);
        }
    }

    public static void removeUserByUsername(String username) {
        for (int i = 0; i < MultiplayerUsers.size(); i++)
            if (MultiplayerUsers.get(i).username.equals(username)) {
                MultiplayerUsers.remove(i);
                break;
            }
    }

    public static String randomAnswer(ArrayList<String> answers) {
        Random random = new Random();
        int rand = random.nextInt(answers.size());
        String answer = answers.get(rand);
        answers.remove(rand);
        return answer;
    }

    private static Question randomQuestion(ArrayList<Question> questions2) {
        if (questions2.size() > 0) {
            Random random = new Random();
            int rand = random.nextInt(questions2.size());
            Question question = questions2.get(rand);
            questions2.remove(rand);
            return question;
        } else {
            return null;
        }
    }

    public static boolean startTheGame() {
        if (CLIENT_HANDLERS_MULTIPLAYER.size() == 2) {
            for (var clientHandlersMultiplayer : CLIENT_HANDLERS_MULTIPLAYER)
                clientHandlersMultiplayer.sendResponseStr(Responses.ACCEPT.response);

            return true;
        }

        return false;
    }

    public static String randomCategoryName(ArrayList<String> arrayList) {
        Random random = new Random();
        int rand = random.nextInt(arrayList.size());
        String randomCategory = arrayList.get(rand);
        arrayList.remove(rand);
        return randomCategory;
    }

    public static void sendRandomCategoryName(ArrayList<String> arrayList) {
        Random random = new Random();
        int rand = random.nextInt(CLIENT_HANDLERS_MULTIPLAYER.size());

        String categoryButton1 = randomCategoryName(arrayList);
        String categoryButton2 = randomCategoryName(arrayList);

        for (int i = 0; i < CLIENT_HANDLERS_MULTIPLAYER.size(); i++) {
            CLIENT_HANDLERS_MULTIPLAYER.get(i).sendResponseStr(categoryButton1);
            CLIENT_HANDLERS_MULTIPLAYER.get(i).sendResponseStr(categoryButton2);
            if (i == rand)
                CLIENT_HANDLERS_MULTIPLAYER.get(i).sendResponseStr(Responses.ACCEPT.response);
            else
                CLIENT_HANDLERS_MULTIPLAYER.get(i).sendResponseStr(Responses.REJECT.response);
        }
    }

    public static void sendSelectedCategoryName(String category) {
        for (var clientHandlersMultiplayer : CLIENT_HANDLERS_MULTIPLAYER)
            clientHandlersMultiplayer.sendResponseStr(category);
    }

    public static void changeState(Socket socket, ArrayList<ClientHandler> arrayList1, ArrayList<ClientHandler> arrayList2) {
        for (int i = 0; i < arrayList1.size(); i++) {
            if (arrayList1.get(i).SOCKET.getRemoteSocketAddress().equals(socket.getRemoteSocketAddress())) {
                arrayList2.add(arrayList1.get(i));
                arrayList1.remove(i);
                break;
            }
        }
    }
}
