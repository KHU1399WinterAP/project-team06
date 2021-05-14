package main.java.gui.theme;

import main.java.gui.Dashord.Dashboard;
import main.java.models.Theme;
import main.java.socket.Client;

import java.util.ArrayList;

public class ThemeTypes {
    private static final Client client = Dashboard.CLIENT;
    public static ArrayList<Theme> themes = getThemes();

    private static ArrayList<Theme> getThemes() {
        assert client != null;
        client.sendRequest("getThemes");

        ArrayList<Theme> themes = new ArrayList<>();
        int themesSize = client.getResponseInt();


        for (int i = 0; i < themesSize; i++) {
         Theme theme=new Theme(client.getResponseInt(), client.getResponse(),
                 client.getResponse(), client.getResponse());

         themes.add(theme);
        }

        return themes;
    }
}
