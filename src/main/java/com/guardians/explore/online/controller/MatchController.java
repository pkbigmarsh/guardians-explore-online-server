package com.guardians.explore.online.controller;

import com.guardians.explore.online.model.Match;
import com.guardians.explore.online.model.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MatchController {
	private Map<UUID, Match> matchMap; // ID - Match
    private Map<String, Player> playerMap; // ID - Player

	public MatchController() {
		this.matchMap = new HashMap<>();
        this.playerMap = new HashMap<>();
	}

	public Match createNewMatch(String username) {
	    final Player playerOne;
	    if (playerMap.containsKey(username)) {
	        playerOne = playerMap.get(username);
        } else {
            playerOne = Player.builder()
                    .setUsername(username)
                    .build();
        }

        final Match match = new Match(playerOne);
        matchMap.put(match.getGameId(), match);

        return match;
    }
}