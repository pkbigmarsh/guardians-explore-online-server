package com.guardians.explore.online.model;

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Player {
	private final String username;
	private String socketId; // This probably won't be a string, but I don't know what it needs to be right now

    private static final String NULL_EMPTY_USERNAME_ERROR = "Player's username cannot be null or empty";
    private static final String NULL_EMPTY_SOCKET_ID_ERROR = "Player's socket id cannot be null or empty";

	private Player(Builder builder) {
		this.username = Validate.notEmpty(builder.username, NULL_EMPTY_USERNAME_ERROR);

        if (builder.socketId != null) {
            this.setSocketId(builder.socketId);
        }
	}

	public String getUsername() {
		return this.username;
	}

	public String getSocketId() {
		return this.socketId;
	}

	public void setSocketId(String socketId) {
	    this.socketId = Validate.notEmpty(socketId, NULL_EMPTY_SOCKET_ID_ERROR);
    }

    public void removeSocketId() {
        this.socketId = null;
    }

	public static Builder builder() {
		return new Builder();
	}

	@Override
	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass()) {
			return false;
		}

		if (other == this) {
			return true;
		}

		final Player that = (Player) other;

		return new EqualsBuilder()
				.append(username, that.username)
				.append(socketId, that.socketId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(username)
				.append(socketId)
				.hashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("username", username)
				.append("socketId", socketId)
				.toString();
	}

	public static class Builder {
		private String username;
		private String socketId;

		protected Builder() {

		}

		public Builder setUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder setSocketId(String socketId) {
			this.socketId = socketId;
			return this;
		}

		public Player build() {
			return new Player(this);
		}
	}
}