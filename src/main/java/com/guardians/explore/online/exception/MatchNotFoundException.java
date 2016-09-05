package com.guardians.explore.online.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MatchNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Unable to find Match with ID [%s]";

    public MatchNotFoundException(UUID matchId) {
        super(String.format(MESSAGE_TEMPLATE, matchId.toString()));
    }
}
