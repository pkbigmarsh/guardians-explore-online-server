package com.guardians.explore.online.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MatchIsFullException extends RuntimeException{
    public static final String ERROR_MESSAGE_FORMAT = "Match [%s] is already full";

    public MatchIsFullException(UUID matchId) {
        super(String.format(ERROR_MESSAGE_FORMAT, matchId.toString()));
    }

}
