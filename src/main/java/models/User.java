package main.java.models;

public class User {
    public String username;
    public String password;
    public int profilePicture;
    public int coins;

    public User(String username,String password,int profilePicture,int coins){
        this.username=username;
        this.password=password;
        this.profilePicture=profilePicture;
        this.coins=coins;
    }
    public User(String username,char[] password,int profilePicture,int coins) {
        this(username,String.valueOf(password),profilePicture,coins);
    }

    @Override
    public String toString() {
        return "User : " +"\n"+
                " username = " + username + "\n" +
                " password = " + password + "\n"
                ;
    }
}
