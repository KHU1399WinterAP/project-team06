package main.java.database;

import main.java.config.DatabaseConfig;
import main.java.models.User;

import java.sql.*;
import java.util.ArrayList;

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
            if (resultSet.next())
                return new User(resultSet.getString("username"), resultSet.getString("password"),resultSet.getInt("profilepicture"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

//    public static ArrayList<User> SelectAllUsers() {
//        try {
//            var users = new ArrayList<User>();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM user ");
//
//            while (resultSet.next()) {
//                User user = new User(resultSet.getString("username"), resultSet.getString("password"));
//                users.add(user);
//            }
//            return users;
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            return new ArrayList<>();
//        }
//    }

    public static void InsertInToUsers(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user VALUES(?,?,?)");
            statement.setString(1, user.username);
            statement.setString(2, user.password);
            statement.setInt(3,user.profilePicture);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean AlreadyExisted(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE username=?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(username)) return true;
            }
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return true;
        }
    }

    public static void UpdateDatabaseUsername(String username,String newUsername){
        try {
            PreparedStatement statement=connection.prepareStatement("UPDATE user SET username=? WHERE username=?");
            statement.setString(1,newUsername);
            statement.setString(2,username);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void UpdateDatabasePassword(String username,String newPassword){
        try {
            PreparedStatement statement=connection.prepareStatement("UPDATE user SET password=? WHERE username=?");
            statement.setString(1,newPassword);
            statement.setString(2,username);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void UpdateDatabaseProfilePicture(String username,int profilePicture){
        try {
            PreparedStatement statement=connection.prepareStatement("UPDATE user SET profilepicture=? WHERE username=?");
            statement.setInt(1,profilePicture);
            statement.setString(2,username);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
