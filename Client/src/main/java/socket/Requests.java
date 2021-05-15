package main.java.socket;

public enum Requests {
    REGISTER("REGISTER"),
    LOGIN("LOGIN"),
    GET_QUESTIONS("GET_QUESTIONS"),
    ACCEPT("ACCEPT");

    public String request;

    Requests(String request) {
        this.request = request;
    }
}
