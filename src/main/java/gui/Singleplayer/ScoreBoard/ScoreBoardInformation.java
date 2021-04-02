package main.java.gui.Singleplayer.ScoreBoard;

import java.util.ArrayList;

public class ScoreBoardInformation {
    String username;
    int record;

    public ScoreBoardInformation(String username, int record) {
        this.username = username;
        this.record = record;
    }

    @Override
    public String toString() {
        return "ScoreBoardInformation{" +
                "username='" + username + '\'' +
                ", record=" + record +
                '}';
    }
}
