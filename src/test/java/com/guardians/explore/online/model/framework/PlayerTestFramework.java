package com.guardians.explore.online.model.framework;

public class PlayerTestFramework {
    private static final String VALID_USERNAME = "username";
    private static final String VALID_SOCKET_ID = "socket_id";
    private static final String EMPTY_STRING = "";
    private static final String STRING_MODIFIER = "_string";

    private static final String USERNAME_CONSTRUCTOR_ERROR_MESSAGE = "Player's username cannot be null or empty";
    private static final String SOCKET_ID_CONSTRUCTOR_ERROR_MESSAGE = "Player's socket id cannot be null or empty";


    protected String getValidUsername() {
        return VALID_USERNAME;
    }

    protected String getValidSocketId() {
        return VALID_SOCKET_ID;
    }

    protected String getUsernameConstructorErrorMessage() {
        return USERNAME_CONSTRUCTOR_ERROR_MESSAGE;
    }

    protected String getSocketIdConstructorErrorMessage() {
        return SOCKET_ID_CONSTRUCTOR_ERROR_MESSAGE;
    }

    protected String getEmptyString() {
        return EMPTY_STRING;
    }

    protected String getStringModifier() {
        return STRING_MODIFIER;
    }
}
