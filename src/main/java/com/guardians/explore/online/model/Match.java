package com.guardians.explore.online.model;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.UUID;

public class Match {

	public static final int MAX_PLAYERS = 5;

	private final UUID gameId;

	private Player[] players;  

	public Match(Player playerOne) {
		this.gameId = UUID.randomUUID();

		this.players = new Player[MAX_PLAYERS];
		this.players[0] = Validate.notNull(playerOne, "Player One cannot be null");
	}

	private Match(UUID gameId, Player[] players) {
	    this.gameId = gameId;
        this.players = players;
    }

	public UUID getGameId() {
		return this.gameId;
	}

	public Player[] getPlayers() {
		return this.players;
	}

	/* package */ Match copy() {
	    return new Match(gameId, players);
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
				.append(gameId, that.gameId)
				.append(players, that.players)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(gameId)
				.append(players)
				.hashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("gameId", gameId)
				.append("players", players)
				.toString();
	}
}