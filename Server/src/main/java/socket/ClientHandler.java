package main.java.socket;

import main.java.Database.Database;
import main.java.models.*;
import main.java.utils.GuiValidation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class ClientHandler extends Thread {
    private static final String ACCEPT_MESSAGE = "ACCEPT";
    private static final String REJECT_MESSAGE = "REJECT";

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
                var command = getRequest();
                String username;
                String password;

                switch (command) {
                    case "REGISTER":
                        username = getRequest();
                        password = getRequest();

                        var usernameError = GuiValidation.validateUsername(username);
                        var passwordError = GuiValidation.validatePassword(password);

                        if (Database.AlreadyExisted(username))
                            sendResponseStr("ALREADY_EXIST");

                        else if (usernameError == null && passwordError == null) {
                            int settingId = Database.getTheMaxSettingId() + 1;
                            Settings settings = new Settings(settingId);
                            Database.insertInToSettings(settings);
                            User user = new User(username, Objects.hash(password), settingId);
                            Database.insertInToUsers(user);

                            sendResponseStr(ACCEPT_MESSAGE);
                            sendResponseInt(settingId);
                        } else {
                            sendResponseStr(REJECT_MESSAGE);
                            assert usernameError != null;
                            sendResponseStr(usernameError.getMessage());
                            sendResponseStr(passwordError.getMessage());
                        }
                        break;

                    case "LOGIN":
                        username = getRequest();
                        password = getRequest();

                        User user = Database.getUserByUsername(username);

                        if (user != null && user.password == Integer.parseInt(password) && !username.isBlank()) {

                            DATA_OUTPUT_STREAM.writeUTF(ACCEPT_MESSAGE);
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
                            sendResponseStr(REJECT_MESSAGE);
                        break;

                    case "ThemeId":
                        username = getRequest();
                        sendResponseInt(Database.getThemeIdByUsername(username));
                        break;

                    case "getThemes":
                        ArrayList<Theme> themes = Database.getAllTheme();
                        assert themes != null;
                        sendResponseInt(themes.size());

                        for (Theme theme : themes) {
                            sendResponseInt(theme.id);
                            sendResponseStr(theme.background);
                            sendResponseStr(theme.button);
                            sendResponseStr(theme.name);
                        }
                        break;

                    case "UPDATE_THEME":
                        username = getRequest();
                        int NewThemeId = Integer.parseInt(getRequest());
                        Database.updateThemeByUsername(username, NewThemeId);
                        break;

                    case "UPDATE_SETTINGS":
                        username = getRequest();
                        password = getRequest();
                        int profilePicture = Integer.parseInt(getRequest());

                        String newUsername = getRequest();
                        String newPassword = getRequest();
                        int newProfilePicture = Integer.parseInt(getRequest());

                        usernameError = GuiValidation.validateUsername(newUsername);
                        passwordError = GuiValidation.validatePassword(newPassword);

                        if (username.equals(newUsername) && newPassword.equals(password) &&
                                newProfilePicture == profilePicture)
                            sendResponseStr(REJECT_MESSAGE);
                        else {
                            if (Database.AlreadyExisted(newUsername) && !username.equals(newUsername))
                                sendResponseStr("ALREADY_EXIST");
                            else if (usernameError == null && passwordError == null) {
                                sendResponseStr(ACCEPT_MESSAGE);

                                if (profilePicture != newProfilePicture) {
                                    sendResponseStr("CHANGE_PROFILE_PICTURE");
                                    Database.updateDatabaseProfilePicture(username, newProfilePicture);
                                }

                                if (!password.equals(newPassword)) {
                                    sendResponseStr("CHANGE_PASSWORD");
                                    Database.updateDatabasePassword(username, newPassword);

                                }

                                if (!username.equals(newUsername)) {
                                    sendResponseStr("CHANGE_USERNAME");
                                    Database.updateDatabaseUsername(username, newUsername);
                                }

                                sendResponseStr("OVER");
                            }
                        }
                        break;

                    case "INIT_RECORDS":
                        sendResponseInt(Database.getTheBestRecord(UserColumns.ENGLISH.column));
                        sendResponseInt(Database.getTheBestRecord(UserColumns.MATHEMATICS.column));
                        sendResponseInt(Database.getTheBestRecord(UserColumns.FOOD_DRINK.column));
                        sendResponseInt(Database.getTheBestRecord(UserColumns.SCIENCE.column));
                        sendResponseInt(Database.getTheBestRecord(UserColumns.COMMON_KNOWLEDGE.column));
                        sendResponseInt(Database.getTheBestRecord(UserColumns.GEOGRAPHY.column));

                        break;

                    case "USER_ORDER_BY_RECORDS":
                        String column = getRequest();
                        ArrayList<ScoreBoardInformation> information = Database.getUserOrderedByRecords(column);

                        sendResponseInt(information.size());
                        for (ScoreBoardInformation scoreBoardInformation : information) {
                            sendResponseStr(scoreBoardInformation.username);
                            sendResponseInt(scoreBoardInformation.record);
                            sendResponseInt(scoreBoardInformation.profilePicture);
                        }

                        break;

                    case "GET_QUESTIONS":
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
                        break;

                    case "UPDATE_COINS":
                        username=getRequest();
                        int newCoins=Integer.parseInt(getRequest());
                        Database.updateDatabaseUserCoins(username, newCoins);

                        break;

                    case "UPDATE_RECORDS":
                        username=getRequest();
                        String recordColumn=getRequest();
                        int score=Integer.parseInt(getRequest());

                        Database.updateDatabaseUserRecord(username, recordColumn, score);

                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
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
