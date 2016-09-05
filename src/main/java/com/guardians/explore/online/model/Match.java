package com.guardians.explore.online.model;

import com.guardians.explore.online.exception.MatchIsFullException;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.UUID;

public class Match {

	public static final int MAX_PLAYERS = 5;

	private final UUID matchId;

	private Player[] players;
	private int numberOfPlayers;

	public Match(Player playerOne) {
		this.matchId = UUID.randomUUID();

		this.players = new Player[MAX_PLAYERS];
		this.players[0] = Validate.notNull(playerOne, "Player One cannot be null");
        numberOfPlayers = 1;
	}

	private Match(UUID matchId, Player[] players) {
	    this.matchId = matchId;
        this.players = players;
    }

	public UUID getMatchId() {
		return this.matchId;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	public Player getFirstPlayer() {
	    return this.players[0];
    }

    public void addPlayer(Player newPlayer) {
        if (numberOfPlayers == 5) {
            throw new MatchIsFullException(matchId);
        } else {
            players[numberOfPlayers] = newPlayer;
            numberOfPlayers += 1;
        }
    }

	/* package */ Match copy() {
	    return new Match(matchId, players);
    }

	@Override
	public boolean equals(Object other) {
		if (other == null || this.getClass() != other.getClass()) {
			return false;
		}

		if (this == other) {
			return true;
		}

		Match that = (Match) other;

		return new EqualsBuilder()
				.append(matchId, that.matchId)
				.append(players, that.players)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(matchId)
				.append(players)
				.hashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("matchId", matchId)
				.append("players", players)
				.toString();
	}
}