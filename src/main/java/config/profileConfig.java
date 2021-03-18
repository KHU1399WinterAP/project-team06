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
        String picture8="/main/resources/icons/Avatars/face8.png";
        String picture9="/main/resources/icons/Avatars/face9.png";
        String picture10="/main/resources/icons/Avatars/face10.png";
        String picture11="/main/resources/icons/Avatars/face11.png";
        String picture12="/main/resources/icons/Avatars/face12.png";
        if (user.profilePicture==2) return picture2;
        if (user.profilePicture==3) return picture3;
        if (user.profilePicture==4) return picture4;
        if (user.profilePicture==5) return picture5;
        if (user.profilePicture==6) return picture6;
        if (user.profilePicture==7) return picture7;
        if (user.profilePicture==8) return picture8;
        if (user.profilePicture==9) return picture9;
        if (user.profilePicture==10) return picture10;
        if (user.profilePicture==11) return picture11;
        if (user.profilePicture==12) return picture12;
        else return picture1;
    }

}
