package com.guardians.explore.online.controller;

import com.guardians.explore.online.exception.MatchNotFoundException;
import com.guardians.explore.online.model.Match;
import com.guardians.explore.online.model.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MatchController {
	private Map<UUID, Match> matchMap; // ID - Match

	public MatchController() {
		this.matchMap = new HashMap<>();
	}

	public Match createNewMatch(String username) {
	    final Player playerOne = Player.builder()
                .setUsername(username)
                .build();

        final Match match = new Match(playerOne);
        matchMap.put(match.getMatchId(), match);

        return match;
    }

    /**
     * Joins the given match
     * @param matchId the game's id
     * @param username the user joining the game
     * @return the newly created socketId for the joining user
     */
    public String joinMatch(UUID matchId, String username) {
        if (!matchMap.containsKey(matchId)) {
            throw new MatchNotFoundException(matchId);
        }

        final Match match = matchMap.get(matchId);

        if (match.getFirstPlayer().getUsername().equals(username)) {
            final Player firstPlayer = match.getFirstPlayer();

            firstPlayer.setSocketId(UUID.randomUUID().toString());

            return firstPlayer.getSocketId();
        }

        Player newPlayer = Player.builder()
                .setUsername(username)
                .setSocketId(UUID.randomUUID().toString())
                .build();

        match.addPlayer(newPlayer);
        return newPlayer.getSocketId();
    }
}