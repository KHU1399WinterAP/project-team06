package main.java.config;

import jaco.mp3.player.MP3Player;

import java.io.File;

public class MusicConfig {
    public static final String gamePLaySong = "src\\main\\resources\\music\\gamePlay.mp3";
    public static final String LoginSong = "src\\main\\resources\\music\\Imagine_Dragons_Believer_320.mp3";
    public static final String celClickSong = "src\\main\\resources\\music\\cellClick.mp3";
    public static final String QuestionSong = "src\\main\\resources\\music\\questionScene.mp3";
    public static final String clockFastSong = "src\\main\\resources\\music\\tickTockFast.mp3";
    public static final String clockSlowSong = "src\\main\\resources\\music\\tickTockSlow.mp3";
    public static final String correctSong = "src\\main\\resources\\music\\correct.mp3";
    public static final String wrongSong = "src\\main\\resources\\music\\wrong.mp3";

    public static MP3Player mp3PlayerLong;
    public static MP3Player mp3PlayerShort;
    public static MP3Player mp3PlayerClockFast=new MP3Player(new File(clockFastSong));
    public static MP3Player mp3PlayerClockSlow=new MP3Player(new File(clockSlowSong));

    public static void initLongMusic(String song){
        mp3PlayerLong = new MP3Player(new File(song));
        mp3PlayerLong.play();
        mp3PlayerLong.setRepeat(true);
    }

    public static void initShortMp3(String song){
        mp3PlayerShort = new MP3Player(new File(song));
        mp3PlayerShort.play();
    }

    public static void initClockMp3( MP3Player mp3Player){
        mp3Player.play();
        mp3Player.setRepeat(true);
    }
}
