package main.java.models;

public class ScoreBoardInformation {
    public String username;
    public int record;
    public int profilePicture;

    public ScoreBoardInformation(String username, int record,int profilePicture) {
        this.username = username;
        this.record = record;
        this.profilePicture=profilePicture;
    }

    @Override
    public String toString() {
        return "ScoreBoardInformation{" +
                "username='" + username + '\'' +
                ", record=" + record +
                ", profilePicture=" + profilePicture +
                '}';
    }
}
