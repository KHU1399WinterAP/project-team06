package main.java.models;

public enum UserColumns {
    ENGLISH("recordEnglish"),
    MATHEMATICS("recordMath"),
    FOOD_DRINK("recordFood"),
    SCIENCE("recordScience"),
    COMMON_KNOWLEDGE("recordCommon"),
    GEOGRAPHY("recordGeography");

    public String column;

    UserColumns(String column){
        this.column=column;
    }
}