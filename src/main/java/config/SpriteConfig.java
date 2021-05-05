package main.java.config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteConfig {
    public static final URL BACKGROUND_URL = SpriteConfig.class.getResource("/main/resources/icons/Theme/Background.jpg");
    public static final URL CLOCK_URL = SpriteConfig.class.getResource("/main/resources/icons/Theme/hqtimer.png");
    public static final URL CLOCK_RED_URL= SpriteConfig.class.getResource("/main/resources/icons/Theme/hqtimer -red.png");

    public static final BufferedImage BACKGROUND = createImage(BACKGROUND_URL);
    public static final Icon CLOCK_PURPLE=createIcon(CLOCK_URL,"clock");
    public static final Icon CLOCK_RED=createIcon(CLOCK_RED_URL,"clock");


    private static BufferedImage createImage(URL url) {
        try {
            if (url != null) return ImageIO.read(url);

            System.out.println("Cannot find Background !");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Icon createIcon(URL url, String name){
        if (url!=null)
            return new ImageIcon(url);

        printError(name);
        return null;
    }

    private static void printError(String name){
        System.out.printf("cannot find %s sprite.\n",name);
    }
}
