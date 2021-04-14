package main.java.database;

import main.java.config.DatabaseConfig;
import main.java.gui.theme.ThemeTypes;
import main.java.models.ScoreBoardInformation;
import main.java.models.Question;
import main.java.models.Settings;
import main.java.models.Theme;
import main.java.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Database {
    private static Connection connection = null;

    static {
        try {
            connection = DriverManager.getConnection(
                    DatabaseConfig.CONNECTION_URL, DatabaseConfig.USERNAME, DatabaseConfig.PASSWORD);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static User getUserByUsername(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username =?");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {

                int password = resultSet.getInt("password");
                int profilePicture = resultSet.getInt("profilepicture");
                int settingsId = resultSet.getInt("settingId");
                int coins = resultSet.getInt(("coins"));
                int recordEnglish = resultSet.getInt("recordEnglish");
                int recordMath = resultSet.getInt("recordMath");
                int recordFood = resultSet.getInt("recordFood");
                int recordScience = resultSet.getInt("recordScience");
                int recordCommon = resultSet.getInt("recordCommon");
                int recordGeography = resultSet.getInt("recordGeography");

                return new User(username, password, settingsId, profilePicture, coins, recordEnglish,
                        recordMath, recordFood, recordScience, recordCommon, recordGeography);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Question> SelectAllQuestions(int category) {
        try {
            ArrayList<Question> questions = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM questions WHERE category=?");
            statement.setInt(1, category);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {

                int questionIndex = resultSet.getInt("QuestionIndex");
                String answer1 = resultSet.getString("answer1");
                String answer2 = resultSet.getString("answer2");
                String answer3 = resultSet.getString("answer3");
                String correctAnswer = resultSet.getString("correctanswer");
                String questionText = resultSet.getString("question");
                Question question = new Question(category, questionIndex, answer1, answer2, answer3, correctAnswer, questionText);

                questions.add(question);
            }
            return questions;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void insertInToUsers(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1, user.username);
            statement.setInt(2, user.password);
            statement.setInt(11, user.settingId);
            statement.setInt(3, user.profilePicture);
            statement.setInt(4, user.coins);
            statement.setInt(5, user.recordEnglish);
            statement.setInt(6, user.recordMath);
            statement.setInt(7, user.recordFood);
            statement.setInt(8, user.recordScience);
            statement.setInt(9, user.recordCommon);
            statement.setInt(10, user.recordGeography);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<Theme> getAllTheme() {
        ArrayList<Theme> themes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM theme");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                themes.add(convertResultSetToTheme(resultSet));
            }
            return themes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private static Theme convertResultSetToTheme(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String background = resultSet.getString("background");
        String button = resultSet.getString("button");
        String name=resultSet.getString("name");
        return new Theme(id, background, button,name);
    }

    public static void updateThemeByUsername(String username, int themeId) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user,setting SET setting.themeId=? WHERE user.username=? AND user.settingId=setting.id;");
            statement.setInt(1, themeId);
            statement.setString(2, username);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int getThemeIdByUsername(String username){
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT setting.themeId FROM user,setting WHERE user.username=? AND user.settingId=setting.id;");
            statement.setString(1,username);
            ResultSet resultSet=statement.executeQuery();
            if (resultSet.next())
                return resultSet.getInt("themeId");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static boolean AlreadyExisted(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username=?");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("username").equals(username);
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return true;
        }
    }

    public static void updateDatabaseUsername(String username, String newUsername) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user SET username=? WHERE username=?");
            statement.setString(1, newUsername);
            statement.setString(2, username);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateDatabasePassword(String username, String newPassword) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user SET password=? WHERE username=?");
            statement.setInt(1, Objects.hash(newPassword));
            statement.setString(2, username);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateDatabaseProfilePicture(String username, int profilePicture) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user SET profilepicture=? WHERE username=?");
            statement.setInt(1, profilePicture);
            statement.setString(2, username);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateDatabaseUserCoins(String username, int newCoin) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user SET coins=? WHERE username=?");
            statement.setInt(1, newCoin);
            statement.setString(2, username);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateDatabaseUserRecord(String username, String column, int newRecord) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE user SET " + column + "=? WHERE username=?");
            statement.setString(2, username);
            statement.setInt(1, newRecord);

            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int getTheBestRecord(String column) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(" + column + ") as " + column + " FROM user");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(column);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static int getTheMaxSettingId() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT MAX(settingId) as settingId FROM user");
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return resultSet.getInt("settingId");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public static void insertInToSettings(Settings settings) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO setting VALUES (?,?)");
            statement.setInt(1,settings.id);
            statement.setInt(2,settings.themeId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static ArrayList<ScoreBoardInformation> getUserOrderedByRecords(String column){
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT username,"+column+",profilepicture FROM user ORDER BY "+column+" desc");
            ResultSet resultSet=statement.executeQuery();
            ArrayList<ScoreBoardInformation> usersOrderedByRecords=new ArrayList<>();
            int max=20;
            while (resultSet.next() && max>0){
                String username=resultSet.getString("username");
                int record=resultSet.getInt(column);
                int profilePicture=resultSet.getInt("profilepicture");
                ScoreBoardInformation scoreBoardInformation=new ScoreBoardInformation(username,record,profilePicture);
                usersOrderedByRecords.add(scoreBoardInformation);
                max--;
            }
            return usersOrderedByRecords;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new ArrayList<>();
    }
}
