package main.java.animations;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

import static main.java.config.GuiConfig.COLOR_DANGER;

public class RunAnimation {
    public static void  runMainPanelBackgroundColorAnimation(JPanel mainBackground) {
        Consumer<Color> stepCallback = mainBackground::setBackground;
        Runnable endCallback = () -> mainBackground.setBackground(new Color(0, 112, 192));
        new ColorChangeAnimation(mainBackground.getBackground(), COLOR_DANGER, stepCallback, endCallback).start();
    }
}
