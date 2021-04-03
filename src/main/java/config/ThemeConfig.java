package main.java.config;

import main.java.gui.theme.ThemeTypes;
import main.java.models.Theme;

import java.awt.*;

public class ThemeConfig {
    public static Color background;
    public static Color button;
    public static int themeId;

    public static void initTheme(){
        Theme theme = null;
        for (int i = 0; i < ThemeTypes.themes.size(); i++) {
            if (themeId == ThemeTypes.themes.get(i).id) {
                theme = ThemeTypes.themes.get(i);
            }
        }
        assert theme != null;
        background = Color.decode(theme.background);
        button = Color.decode(theme.button);
    }
}
