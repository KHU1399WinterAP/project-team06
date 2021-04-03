package main.java.models;

public class ScoreBoardInformation {
    public String username;
    public int record;

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
