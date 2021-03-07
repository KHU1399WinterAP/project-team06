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

    public static ArrayList<User> SelectAllUsers() {
        try {
            var users = new ArrayList<User>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user ");

            while (resultSet.next()) {
                User user = new User(resultSet.getString("username"), resultSet.getString("password"));
                users.add(user);
            }
            return users;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void InsertInToUsers(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO user VALUES(?,?)");
            statement.setString(1, user.username);
            statement.setString(2, user.password);
            statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static boolean AlreadyExisted(String username){
        try{
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM user WHENEVER username=?");
            statement.setString(1,username);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}
