package main.java.socket;

import main.java.Database.Database;
import main.java.app.AppManager;
import main.java.models.*;
import main.java.utils.GuiValidation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class ClientHandler extends Thread {
    public final Socket SOCKET;
    public final DataInputStream DATA_INPUT_STREAM;
    public final DataOutputStream DATA_OUTPUT_STREAM;

    public ClientHandler(Socket socket) throws IOException {
        this.SOCKET = socket;
        System.out.println("Connected to " + socket.getRemoteSocketAddress());

        this.DATA_INPUT_STREAM = new DataInputStream(SOCKET.getInputStream());
        this.DATA_OUTPUT_STREAM = new DataOutputStream(SOCKET.getOutputStream());
    }

    @Override
    public void run() {
        try {
            while (true) {
                var command = DATA_INPUT_STREAM.readUTF();

                switch (command) {
                    case "REGISTER" -> register();
                    case "LOGIN" -> login();
                    case "LOG_OUT" -> logout();
                    case "ThemeId" -> getThemIdByUsernames();
                    case "getThemes" -> getAllThemes();
                    case "UPDATE_THEME" -> updateTheme();
                    case "UPDATE_SETTINGS" -> updateSettings();
                    case "INIT_RECORDS" -> initRecords();
                    case "USER_ORDER_BY_RECORDS" -> getUserOrder();
                    case "GET_QUESTIONS" -> getQuestions();
                    case "UPDATE_COINS" -> updateCoins();
                    case "UPDATE_RECORDS" -> updateRecords();
                    case "SEND_MESSAGE" -> sendMessage();
                    case "UPDATE_CHET" -> updateChet();
                    case "WAIT_FOR_OTHER_PLAYER" -> waitForOtherPlayer();
                    case "OUT_OF_MULTIPLAYER" -> outOfMultiPlayer();
                    case "SEND_SELECTED_CATEGORY"-> sendSelectedCategory();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void outOfMultiPlayer() {
        AppManager.changeState(this.SOCKET, AppManager.CLIENT_HANDLERS_MULTIPLAYER, AppManager.CLIENT_HANDLERS);
    }

    private void logout() {
        String username = getRequest();

        for (int i = 0; i < AppManager.EnteredUsers.size(); i++) {
            if (username.equals(AppManager.EnteredUsers.get(i).username)) {
                AppManager.EnteredUsers.remove(i);
                break;
            }
        }
    }

    private void waitForOtherPlayer() {
        AppManager.changeState(this.SOCKET, AppManager.CLIENT_HANDLERS, AppManager.CLIENT_HANDLERS_MULTIPLAYER);

       if (!AppManager.startTheGame()) return;

        ArrayList<String> categories = new ArrayList<>(
                Arrays.asList("English", "Math", "Food", "Science", "Common", "Geography"));

        AppManager.sendRandomCategoryName(categories);
    }

    private void sendSelectedCategory(){
        String selectedCategory=getRequest();
        AppManager.sendSelectedCategoryName(selectedCategory);
    }

    private void updateChet() {
        AppManager.syncChet();
    }

    private void sendMessage() {
        String name = getRequest();
        String message = getRequest();
        AppManager.addMessage(name, message);
        AppManager.syncChet();
    }

    private void updateRecords() {
        String username = getRequest();
        String recordColumn = getRequest();
        int score = Integer.parseInt(getRequest());

        Database.updateDatabaseUserRecord(username, recordColumn, score);
    }

    private void updateCoins() {
        String username = getRequest();
        int newCoins = Integer.parseInt(getRequest());

        Database.updateDatabaseUserCoins(username, newCoins);
    }

    private void register() {
        String username = normalize(getRequest());
        String password = normalize(getRequest());

        var usernameError = GuiValidation.validateUsername(username);
        var passwordError = GuiValidation.validatePassword(password);

        if (Database.AlreadyExisted(username))
            sendResponseStr(Responses.ALREADY_EXIST.response);

        else if (usernameError == null && passwordError == null) {
            int settingId = Database.getTheMaxSettingId() + 1;
            Settings settings = new Settings(settingId);
            Database.insertInToSettings(settings);

            User user = new User(username, Objects.hash(password), settingId);
            Database.insertInToUsers(user);
            AppManager.addUser(user);

            sendResponseStr(Responses.ACCEPT.response);
            sendResponseInt(settingId);
            sendResponseStr(username);
            sendResponseStr(password);
        } else {
            sendResponseStr(Responses.REJECT.response);
            assert usernameError != null;
            sendResponseStr(usernameError.getMessage());
            sendResponseStr(passwordError.getMessage());
        }
    }

    private String normalize(String text) {
        text = text.replaceAll(" +", " ");
        return text.trim();
    }

    private void login() {
        String username = getRequest();
        String password = getRequest();

        User user = Database.getUserByUsername(username);

        if (user != null && user.password == Integer.parseInt(password) && !username.isBlank() && isValid(user.username)) {
            AppManager.addUser(user);
            sendResponseStr(Responses.ACCEPT.response);
            sendResponseInt(user.settingId);
            sendResponseInt(user.profilePicture);
            sendResponseInt(user.coins);
            sendResponseInt(user.recordEnglish);
            sendResponseInt(user.recordMath);
            sendResponseInt(user.recordFood);
            sendResponseInt(user.recordScience);
            sendResponseInt(user.recordCommon);
            sendResponseInt(user.recordGeography);
        } else
            sendResponseStr(Responses.REJECT.response);
    }

    private boolean isValid(String username) {
        for (User user : AppManager.EnteredUsers)
            if (user.username.equals(username))
                return false;

        return true;
    }

    private void getThemIdByUsernames() {
        String username = getRequest();
        sendResponseInt(Database.getThemeIdByUsername(username));
    }

    private void getAllThemes() {
        ArrayList<Theme> themes = Database.getAllTheme();
        assert themes != null;
        sendResponseInt(themes.size());

        for (Theme theme : themes) {
            sendResponseInt(theme.id);
            sendResponseStr(theme.background);
            sendResponseStr(theme.button);
            sendResponseStr(theme.name);
        }
    }

    private void updateTheme() {
        String username = getRequest();
        int NewThemeId = Integer.parseInt(getRequest());

        Database.updateThemeByUsername(username, NewThemeId);
    }

    private void updateSettings() {
        String username = normalize(getRequest());
        String password = normalize(getRequest());
        int profilePicture = Integer.parseInt(getRequest());

        String newUsername = getRequest();
        String newPassword = getRequest();
        int newProfilePicture = Integer.parseInt(getRequest());

        var usernameError = GuiValidation.validateUsername(newUsername);
        var passwordError = GuiValidation.validatePassword(newPassword);

        if (username.equals(newUsername) && newPassword.equals(password) &&
                newProfilePicture == profilePicture)
            sendResponseStr(Responses.REJECT.response);
        else {
            if (Database.AlreadyExisted(newUsername) && !username.equals(newUsername))
                sendResponseStr(Responses.ALREADY_EXIST.response);

            else if (usernameError == null && passwordError == null) {
                sendResponseStr(Responses.ACCEPT.response);

                if (profilePicture != newProfilePicture) {
                    sendResponseStr(Responses.CHANGE_PROFILE_PICTURE.response);
                    Database.updateDatabaseProfilePicture(username, newProfilePicture);
                }

                if (!password.equals(newPassword)) {
                    sendResponseStr(Responses.CHANGE_PASSWORD.response);
                    Database.updateDatabasePassword(username, newPassword);
                }

                if (!username.equals(newUsername)) {
                    sendResponseStr(Responses.CHANGE_USERNAME.response);
                    Database.updateDatabaseUsername(username, newUsername);
                }

                sendResponseStr(Responses.OVER.response);
            }
        }
    }

    private void initRecords() {
        sendResponseInt(Database.getTheBestRecord(UserColumns.ENGLISH.column));
        sendResponseInt(Database.getTheBestRecord(UserColumns.MATHEMATICS.column));
        sendResponseInt(Database.getTheBestRecord(UserColumns.FOOD_DRINK.column));
        sendResponseInt(Database.getTheBestRecord(UserColumns.SCIENCE.column));
        sendResponseInt(Database.getTheBestRecord(UserColumns.COMMON_KNOWLEDGE.column));
        sendResponseInt(Database.getTheBestRecord(UserColumns.GEOGRAPHY.column));
    }

    private void getUserOrder() {
        String column = getRequest();
        ArrayList<ScoreBoardInformation> information = Database.getUserOrderedByRecords(column);

        sendResponseInt(information.size());
        for (ScoreBoardInformation scoreBoardInformation : information) {
            sendResponseStr(scoreBoardInformation.username);
            sendResponseInt(scoreBoardInformation.record);
            sendResponseInt(scoreBoardInformation.profilePicture);
        }
    }

    private void getQuestions() {
        int category = Integer.parseInt(getRequest());
        ArrayList<Question> questions = Database.SelectAllQuestions(category);

        sendResponseInt(questions.size());
        for (Question question : questions) {
            sendResponseInt(question.questionIndex);
            sendResponseStr(question.answer1);
            sendResponseStr(question.answer2);
            sendResponseStr(question.answer3);
            sendResponseStr(question.correctAnswer);
            sendResponseStr(question.question);
        }
    }

    public void sendResponseInt(int text) {
        try {
            DATA_OUTPUT_STREAM.writeUTF(String.valueOf(text));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendResponseStr(String text) {
        try {
            DATA_OUTPUT_STREAM.writeUTF(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRequest() {
        try {
            return DATA_INPUT_STREAM.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
