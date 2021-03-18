package main.java.models;

public class User {
    public String username;
    public String password;
    public int profilePicture;

    public User(String username,String password,int profilePicture){
        this.username=username;
        this.password=password;
        this.profilePicture=profilePicture;

    }
    public User(String username,char[] password,int profilePicture) {
        this(username,String.valueOf(password),profilePicture);
    }

    @Override
    public String toString() {
        return "User : " +"\n"+
                " username = " + username + "\n" +
                " password = " + password + "\n"
                ;
    }
}
