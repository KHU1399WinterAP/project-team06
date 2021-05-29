package main.java.animations;

import main.java.config.SpriteConfig;

import javax.swing.*;

public class ClockAnimation extends Thread {
    public int time=800;
    private final JLabel CLOCK_LABEL;
    private final Icon[] states = {
            SpriteConfig.CLOCK_PURPLE,
            SpriteConfig.CLOCK_RED
    };

    public ClockAnimation(JLabel clockLabel) {
        this.CLOCK_LABEL = clockLabel;
    }

    private int stateIndex = 0;

    @Override
    public void run() {
        try {
            while (time!=0) {
                CLOCK_LABEL.setIcon(states[stateIndex]);
                stateIndex = (stateIndex + 1) % states.length;

                sleep(time);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
