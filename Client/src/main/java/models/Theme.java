package main.java.models;

public class Theme {
    public int id;
    public String name;
    public String background;
    public String button;

    public Theme(int id, String background, String button,String name) {
        this.name=name;
        this.id = id;
        this.background = background;
        this.button = button;
    }

    @Override
    public String toString() {
        return "Theme{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", background='" + background + '\'' +
                ", button='" + button + '\'' +
                '}';
    }
}
