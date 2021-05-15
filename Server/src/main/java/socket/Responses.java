package main.java.socket;

public enum Responses {
    ACCEPT("ACCEPT"),
    REJECT("REJECT"),
    CHANGE_PROFILE_PICTURE("CHANGE_PROFILE_PICTURE"),
    CHANGE_PASSWORD("CHANGE_PASSWORD"),
    CHANGE_USERNAME("CHANGE_USERNAME"),
    OVER("OVER"),
    ALREADY_EXIST("ALREADY_EXIST");

    String response;
    Responses(String response){
        this.response=response;
    }
}
