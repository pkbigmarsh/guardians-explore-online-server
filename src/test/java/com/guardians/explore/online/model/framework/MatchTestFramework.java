package com.guardians.explore.online.model.framework;

import com.guardians.explore.online.model.Match;
import com.guardians.explore.online.model.Player;

public class MatchTestFramework {
    public static final Player VALID_PLAYER = Player.builder()
            .setSocketId("TestSocketId")
            .setUsername("TestUserName")
            .build();

    public static final String NULL_PLAYER_EXCEPTION_MESSAGE = "Player One cannot be null";

    protected Player getValidPlayer() {
        return VALID_PLAYER;
    }

    protected String getNullPlayerExceptionMessage() {
        return NULL_PLAYER_EXCEPTION_MESSAGE;
    }

    protected Match newInstance() {
        return new Match(VALID_PLAYER);
    }
}
