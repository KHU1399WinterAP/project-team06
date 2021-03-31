package main.java.gui.theme;

public enum Themes {
    BLUE("BLUE"),
    DARK("DARK");
    public String theme;

    Themes(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Themes{" +
                "theme='" + theme + '\'' +
                '}';
    }
}
