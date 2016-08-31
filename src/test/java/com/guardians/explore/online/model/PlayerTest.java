package com.guardians.explore.online.model;

import com.guardians.explore.online.model.framework.PlayerTestFramework;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlayerTest extends PlayerTestFramework {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void validConstructor() {
        // Given a valid username and a valid socketId
        final String username = getValidUsername();
        final String socketId = getValidSocketId();

        // When using the Player.Builder to construct a new Player instance
        final Player player = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        // Then the Object will be created successfully
        Assert.assertNotNull("The builder failed to construct a new Player", player);
    }

    @Test
    public void nullUsernameConstructor() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(getUsernameConstructorErrorMessage());

        // Given a null username and a valid socketId
        final String username = null;
        final String socketId = getValidSocketId();

        // When using the Player.Builder to construct a new Player instance
        @SuppressWarnings("unused")
        final Player player = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        // Then the Builder will throw a NullPointerException with the message
        // Player's username cannot be null or empty
    }

    @Test
    public void nullSocketIdConstructor() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(getSocketIdConstructorErrorMessage());

        // Given a valid username and a null socketId
        final String username = getValidUsername();
        final String socketId = null;

        // When using the Player.Builder to construct a new Player instance
        @SuppressWarnings("unused")
        final Player player = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        // Then the Builder will throw a NullPointerException with the message
        // Player's socket id cannot be null or empty
    }

    @Test
    public void emptyUsernameConstructor() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(getUsernameConstructorErrorMessage());

        // Given an empty username and a valid socketId
        final String username = getEmptyString();
        final String socketId = getValidSocketId();

        // When using the Player.Builder to construct a new Player instance
        @SuppressWarnings("unused")
        final Player player = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        // Then the Builder will throw a IllegalArgumentException with the message
        // Player's username cannot be null or empty
    }

    @Test
    public void emptySocketIdConstructor() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(getSocketIdConstructorErrorMessage());

        // Given a valid username and an empty socketId
        final String username = getValidUsername();
        final String socketId = getEmptyString();

        // When using the Player.Builder to construct a new Player instance
        @SuppressWarnings("unused")
        final Player player = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        // Then the Builder will throw an IllegalArgumentException with the message
        // Player's username cannot be null or empty
    }

    @Test
    public void noUsernameConstructor() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(getUsernameConstructorErrorMessage());

        // Given a valid socketId
        final String socketId = getValidSocketId();

        // When using the Player.Builder to construct a new Player instance
        @SuppressWarnings("unused")
        Player player = Player.builder()
                .setSocketId(socketId)
                .build();

        // Then the Builder will throw a NullPointerException with the message
        // Player's username cannot be null or empty
    }

    @Test
    public void noSocketIdConstructor() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(getSocketIdConstructorErrorMessage());

        // Given a valid username
        final String username = getValidUsername();

        // When using the Player.Builder to construct a new Player instance
        Player player = Player.builder()
                .setUsername(username)
                .build();

        // Then the Builder will throw a NullPointerException with the massage
        // Player's socketId cannot be null or empty
    }

    @Test
    public void getUsername() {
        // Given a valid username, a valid socketId and a new Player instance
        final String expectedUsername = getValidUsername();
        final String socketId = getValidSocketId();
        final Player player = Player.builder()
                .setUsername(expectedUsername)
                .setSocketId(socketId)
                .build();

        // When calling getUsername
        final String getUsername = player.getUsername();

        // Then the returned username will equal the expected username
        Assert.assertEquals("The username returned by the Player instance was wrong",
                expectedUsername, getUsername);
    }

    @Test
    public void getSocketId() {
        // Given a valid username, a valid socketId and a new Player instance
        final String username = getValidUsername();
        final String expectedSocketId = getValidSocketId();
        final Player player = Player.builder()
                .setUsername(username)
                .setSocketId(expectedSocketId)
                .build();

        // When calling getSocketId
        final String getSocketId = player.getSocketId();

        // Then the returned socketId will equal the expected socketId
        Assert.assertEquals("The socketId returned by the Player instance was wrong",
                expectedSocketId, getSocketId);
    }

    @Test
    public void equals() {
        // Given a valid username, a valid socketId, and two new Player instances
        // created with the same username and socketId
        final String username = getValidUsername();
        final String socketId = getValidSocketId();

        final Player player1 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        final Player player2 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        // When calling equals
        final boolean equals = player1.equals(player2);

        // Then those two instances will be equals
        Assert.assertTrue("The two Player instances were not equal when they should be",
                equals);
    }

    @Test
    public void equalsDifferentUsername() {
        // Given a valid username, a modified username, a valid socketId, and two new Player instances
        // created with different usernames and the same socketIds
        final String username = getValidUsername();
        final String modifiedUsername = username + getStringModifier();
        final String socketId = getValidSocketId();

        final Player player1 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        final Player player2 = Player.builder()
                .setUsername(modifiedUsername)
                .setSocketId(socketId)
                .build();

        // When calling equals
        final boolean equals = player1.equals(player2);

        // Then those two instances will not be equal
        Assert.assertFalse("The two Player instances were equal when they should not be",
                equals);
    }

    @Test
    public void equalsDifferentSocketId() {
        // Given a valid username, a valid socketId, a modified socketId, and two new Player instances
        // created with the same username and different socketIds
        final String username = getValidUsername();
        final String socketId = getValidSocketId();
        final String modifiedSocketId = socketId + getStringModifier();

        final Player player1 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        final Player player2 = Player.builder()
                .setUsername(username)
                .setSocketId(modifiedSocketId)
                .build();

        // When calling equals
        final boolean equals = player1.equals(player2);

        // Then those two instances will not be equal
        Assert.assertFalse("The two Player instances were equal when they should not be",
                equals);
    }

    @Test
    public void equalsDifferentObject() {
        // Given a new Player instance and a new Object
        final String username = getValidUsername();
        final String socketId = getValidSocketId();

        final Player player1 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        final Object object = new Object();

        // When calling equals
        final boolean equals = player1.equals(object);

        // Then the two objects will not be equal
        Assert.assertFalse("The Player and Object were equal when they should not be",
                equals);
    }

    @Test
    public void equalsNullPlayer() {
        // Given a valid new Player instance and a null Player instance
        final String username = getValidUsername();
        final String socketId = getValidSocketId();

        final Player player1 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        final Player player2 = null;

        // When calling equals
        final boolean equals = player1.equals(player2);

        // Then the two instances will not be equal
        Assert.assertFalse("The Player and null Player were equal when they should not be",
                equals);
    }

    @Test
    public void hashCodeTest() {
        // Given a valid username, a valid socketId, and two new Player instances
        // created with the same username and socketId
        final String username = getValidUsername();
        final String socketId = getValidSocketId();

        final Player player1 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        final Player player2 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        // When calling hashCode
        final int hashCode1 = player1.hashCode();
        final int hashCode2 = player2.hashCode();

        // Then the two hashCodes will be equal
        Assert.assertEquals("The Player's hash codes were different when they should be equal",
                hashCode1, hashCode2);
    }

    @Test
    public void hashCodeDifferentUsername() {
        // Given a valid username, a modified username, a valid socketId, and two new Player instances
        // created with different usernames and the same socketId
        final String username = getValidUsername();
        final String modifiedUsername = username + getStringModifier();
        final String socketId = getValidSocketId();

        final Player player1 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        final Player player2 = Player.builder()
                .setUsername(modifiedUsername)
                .setSocketId(socketId)
                .build();

        // When calling hashCode
        final int hashCode1 = player1.hashCode();
        final int hashCode2 = player2.hashCode();

        // Then the two hashCodes will be different
        Assert.assertNotEquals("The Players hash codes were equal when they should not be",
                hashCode1, hashCode2);
    }

    @Test
    public void hashCodeDifferentSocketId() {
        // Given a valid username, a valid socketId, a modified socketId and two new Player instances
        // created with the same username and different socketIds
        final String username = getValidUsername();
        final String socketId = getValidSocketId();
        final String modifiedSocketId = socketId + getStringModifier();

        final Player player1 = Player.builder()
                .setUsername(username)
                .setSocketId(socketId)
                .build();

        final Player player2 = Player.builder()
                .setUsername(username)
                .setSocketId(modifiedSocketId)
                .build();

        // When calling hashCode
        final int hashCode1 = player1.hashCode();
        final int hashCode2 = player2.hashCode();

        // Then the two hashCodes will be different
        Assert.assertNotEquals("The players hash codes were equal when they should not be",
                hashCode1, hashCode2);
    }
}
