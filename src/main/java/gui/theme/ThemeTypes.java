package main.java.gui.theme;

import main.java.database.Database;
import main.java.models.Theme;

import java.util.ArrayList;

public class ThemeTypes {
   public static ArrayList<Theme> themes= Database.getAllTheme();
}
