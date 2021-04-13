package main.java.config;

import main.java.models.User;

public class ProfileConfig {
    public static String selected= "/main/resources/icons/check.png";
    public static String profilePicture( int profilePicture){
        return "/main/resources/icons/Avatars/face"+profilePicture+".png";
    }
}
