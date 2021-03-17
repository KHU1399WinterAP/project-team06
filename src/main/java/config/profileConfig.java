package main.java.config;

import main.java.models.User;

public class profileConfig {

    public static String profilePicture(User user){
        String picture1="/main/resources/icons/Avatars/face1.png";
        String picture2="/main/resources/icons/Avatars/face2.png";
        String picture3="/main/resources/icons/Avatars/face3.png";
        String picture4="/main/resources/icons/Avatars/face4.png";
        String picture5="/main/resources/icons/Avatars/face5.png";
        String picture6="/main/resources/icons/Avatars/face6.png";
        String picture7="/main/resources/icons/Avatars/face7.png";
        if (user.profilePicture==2) return picture2;
        if (user.profilePicture==3) return picture3;
        if (user.profilePicture==4) return picture4;
        if (user.profilePicture==5) return picture5;
        if (user.profilePicture==6) return picture6;
        if (user.profilePicture==7) return picture7;
        else return picture1;
    }

}
