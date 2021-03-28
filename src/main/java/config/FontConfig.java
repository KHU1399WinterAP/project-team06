package main.java.config;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FontConfig {
    public static Font comic;

    public static void initFonts() {
        try {
            String FONT_FILE_PATH = "main/resources/fonts/comic.ttf";

            var stream = FontConfig.class.getClassLoader().getResourceAsStream(FONT_FILE_PATH);
            if (stream == null)
                throw new FileNotFoundException();

            comic = Font.createFont(Font.TRUETYPE_FONT, stream);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }
}
