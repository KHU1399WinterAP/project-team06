package main.java.app;
import main.java.gui.LoginRegisterMenu.LoginRegisterMenu;
import main.java.socket.Client;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			Client client=new Client();

			new LoginRegisterMenu(client);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
