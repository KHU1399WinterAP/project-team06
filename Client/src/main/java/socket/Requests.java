package main.java.socket;

public enum Requests {
    REGISTER("REGISTER"),
    LOGIN("LOGIN");

    String request;

    Requests(String request) {
        this.request = request;
    }
}
