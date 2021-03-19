package main.java.app;

import jaco.mp3.player.MP3Player;
import main.java.config.FontConfig;
import main.java.gui.LoginRegisterMenu.LoginRegisterMenu;

import java.io.File;

public class Main {

    public static final String song = "src\\main\\resources\\music\\AlanWalker- Faded [MusicFars.iR].mp3";
    public static MP3Player mp3Player;

    public static void main(String[] args) {

        FontConfig.initFonts();

        mp3Player = new MP3Player(new File(song));
        mp3Player.play();
        mp3Player.setRepeat(true);

        new LoginRegisterMenu();
    }
}
