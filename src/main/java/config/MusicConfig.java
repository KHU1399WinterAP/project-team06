package main.java.config;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class MusicConfig {
    public static final String song = "src\\main\\resources\\music\\Imagine_Dragons_Believer_320.mp3";
    public static MP3Player mp3Player;

    public static void initMusic(){
        mp3Player = new MP3Player(new File(song));
        mp3Player.play();
        mp3Player.setRepeat(true);
    }
}
