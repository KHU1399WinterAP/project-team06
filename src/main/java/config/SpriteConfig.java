package main.java.config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class SpriteConfig {
    public static final URL BACKGROUND_URL = SpriteConfig.class.getResource("/main/resources/icons/Theme/Background.jpg");
    public static final BufferedImage BACKGROUND = createImage(BACKGROUND_URL);

    public static final URL BACKGROUNDLogin_URL = SpriteConfig.class.getResource("/main/resources/icons/Theme/login &register.jpg");
    public static final BufferedImage BACKGROUNDLogin = createImage(BACKGROUNDLogin_URL);

    private static BufferedImage createImage(URL url) {
        try {
            if (url != null) return ImageIO.read(url);

            System.out.println("Cannot find Background !");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
