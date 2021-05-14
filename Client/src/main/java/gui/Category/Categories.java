package main.java.gui.Category;

public enum Categories {
    ENGLISH("English"),
    MATHEMATICS("Mathematics"),
    FOOD_DRINK("Food & Drink"),
    SCIENCE("Science"),
    COMMON_KNOWLEDGE("Common Knowledge"),
    GEOGRAPHY("Geography");

    public String category;

    Categories(String category){
        this.category=category;
    }
}
