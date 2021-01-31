package com.projects.bookmacher.exception;

public class AccountNotFoundException extends Exception {

    public final static String CUSTOM_MESSAGE = "Nie znaleziono konta";

    public AccountNotFoundException() {
        super(CUSTOM_MESSAGE);
    }

}
