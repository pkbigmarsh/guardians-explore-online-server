package com.guardians.explore.online.model.framework;

import com.guardians.explore.online.exception.MatchIsFullException;
import com.guardians.explore.online.model.Match;
import com.guardians.explore.online.model.Player;

import java.util.Random;
import java.util.UUID;

public class MatchTestFramework {
    public static final Random random = new Random();

    public static final String NULL_PLAYER_EXCEPTION_MESSAGE = "Player One cannot be null";

    protected Player getValidPlayer() {
        return Player.builder()
                .setSocketId("TestSocketId")
                .setUsername("TestUserName - " + String.valueOf(random.nextInt()))
                .build();
    }

    protected String getNullPlayerExceptionMessage() {
        return NULL_PLAYER_EXCEPTION_MESSAGE;
    }

    protected Match newInstance() {
        return new Match(getValidPlayer());
    }

    protected String getMatchIsFullExceptionMessage(UUID matchId) {
        return String.format(MatchIsFullException.ERROR_MESSAGE_FORMAT, matchId.toString());
    }
}
