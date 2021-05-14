package main.java.models;

public class Settings {
    public int id;
    public int themeId;

    public Settings(int id){
        this(id,1);
    }
    public Settings(int id, int themeId) {
        this.id = id;
        this.themeId = themeId;
    }
}
