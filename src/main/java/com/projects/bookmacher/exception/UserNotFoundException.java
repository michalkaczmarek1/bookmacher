package com.projects.bookmacher.exception;

public class UserNotFoundException extends Exception {

    public final static String CUSTOM_MESSAGE = "Nie znaleziono usera";

    public UserNotFoundException() {
        super(CUSTOM_MESSAGE);
    }

}
