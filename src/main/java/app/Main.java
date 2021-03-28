package main.java.app;

import main.java.config.FontConfig;
import main.java.config.MusicConfig;
import main.java.gui.LoginRegisterMenu.LoginRegisterMenu;

public class Main {
	
	public static void main(String[] args) {
		FontConfig.initFonts();
		MusicConfig.initMusic();
		new LoginRegisterMenu();
	}
}
