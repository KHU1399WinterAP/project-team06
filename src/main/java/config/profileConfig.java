package main.java.config;

import main.java.models.User;

public class profileConfig {
    public static String profilePicture(User user){
        return "/main/resources/icons/Avatars/face"+user.profilePicture+".png";
    }
}
