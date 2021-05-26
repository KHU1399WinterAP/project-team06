package main.java.socket;

public enum Requests {
    REGISTER("REGISTER"),
    LOGIN("LOGIN"),
    GET_QUESTIONS("GET_QUESTIONS"),
    ACCEPT("ACCEPT"),
    WAIT_FOR_OTHER_PLAYER("WAIT_FOR_OTHER_PLAYER"),
    LOG_OUT("LOG_OUT"),
    OUT_OF_MULTIPLAYER("OUT_OF_MULTIPLAYER"),
    SEND_SELECTED_CATEGORY("SEND_SELECTED_CATEGORY"),
    GET_QUESTION("GET_QUESTION");

    public String request;

    Requests(String request) {
        this.request = request;
    }
}
