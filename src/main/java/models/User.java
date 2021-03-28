package main.java.models;

public class User {
    public String username;
    public String password;
    public int profilePicture;
    public int coins;
    public int recordEnglish;
    public int recordMath;
    public int recordFood;
    public int recordScience;
    public int recordCommon;
    public int recordGeography;

    public User(String username,String password,int profilePicture,int coins,int recordEnglish,int recordMath,
                int recordFood,int recordScience,int recordCommon,int recordGeography){
        this.recordCommon=recordCommon;
        this.recordEnglish=recordEnglish;
        this.recordFood=recordFood;
        this.recordGeography=recordGeography;
        this.recordMath=recordMath;
        this.recordScience=recordScience;
        this.username=username;
        this.password=password;
        this.profilePicture=profilePicture;
        this.coins=coins;
    }
    public User(String username,char[] password,int profilePicture,int coins,int recordEnglish,int recordMath,
                int recordFood,int recordScience,int recordCommon,int recordGeography) {
        this(username,String.valueOf(password),profilePicture,coins,recordEnglish,recordMath,recordFood,recordScience,recordCommon,
                recordGeography);
    }

}
