package com.guardians.explore.online.model;

import com.guardians.explore.online.model.framework.MatchTestFramework;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;

public class MatchTest extends MatchTestFramework {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void validConstructor() {
        // Given a valid Player
        final Player player = getValidPlayer();

        // When instantiating a new Match
        final Match match = new Match(player);

        // Then the object will be created successfully
        Assert.assertNotNull("The Match Constructor failed to create a new Match", match);
    }

    @Test
    public void nullPlayerConstructor() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage(getNullPlayerExceptionMessage());

        // Given a null Player
        final Player player = null;

        // When instantiating a new Match
        @SuppressWarnings("unused")
        final Match match = new Match(player);

        // Then the object will throw a null pointer exception with the message
        // Player One cannot be null
    }

    @Test
    public void getMatchId() {
        // Given a new instance of a Match
        final Match match = newInstance();

        // When calling getMatchId()
        final UUID matchId = match.getMatchId();

        // Then a valid UUID will be returned
        Assert.assertNotNull("New match failed to create a MatchId", matchId);
    }

    @Test
    public void getPlayers() {
        // Given a valid Player and a new instance of a Match
        final Player player = getValidPlayer();
        final Match match = new Match(player);

        // When calling getPlayers()
        final Player[] players = match.getPlayers();

        // Then an array of players will be returned where:
        // - The first player is the same player as passed in the constructor
        // - All other elements are null
        // - The player array has a size of 5
        Assert.assertEquals("The players array was an unexpected size", 5, players.length);
        Assert.assertEquals("The first player was not equal to the seed player", player, players[0]);
        for (int i = 1; i < players.length; i ++) {
            Assert.assertNull(String.format("Index [%s] of the players array was not null", i), players[i]);
        }
    }

    @Test
    public void doesNotEqualsObject() {
        // Given a new instance of a Match and a valid Object
        final Match match = newInstance();
        final Object object = new Object();

        // When calling equals
        final boolean equals = match.equals(object);

        // Then the Match and Object will not equal
        Assert.assertFalse("The Match and Object were equal when they should not be", equals);
    }

    @Test
    public void doesNotEqualsNull() {
        // Given a new instance of a Match and a null Match
        final Match match = newInstance();
        final Match nullMatch = null;

        // When calling equals
        final boolean equals = match.equals(nullMatch);

        // Then the two will not be equal
        Assert.assertFalse("The Match and Null-Match were equal when they should not be", equals);
    }

    @Test
    public void samePlayerEquals() {
        // Given a valid Player and two new instances of Match
        final Player player = getValidPlayer();

        final Match match1 = new Match(player);
        final Match match2 = new Match(player);

        // When calling equals
        final boolean equals = match1.equals(match2);

        // Then the two will not be equal because of differing matchIds
        Assert.assertFalse("The two Matches were equal when they should not be", equals);
    }

    @Test
    public void matchCopyEquals() {
        // Given a new instance of a Match and a copy of that Match
        final Match match1 = newInstance();
        final Match match2 = match1.copy();

        // When calling equals
        final boolean equals = match1.equals(match2);

        // Then the two will be equal
        Assert.assertTrue("The Match and it's copy were not equal when they should be", equals);
    }

    @Test
    public void sameHashCodeTest() {
        // Given a new instance of a Match and a copy of that Match
        final Match match1 = newInstance();
        final Match match2 = match1.copy();

        // When calling hashCode
        final int hashCode1 = match1.hashCode();
        final int hashCode2 = match2.hashCode();

        // Then the two hashCodes will be different
        Assert.assertEquals("The Match and it's copy did not have the same hash code when they should",
                hashCode1, hashCode2);
    }

    @Test
    public void differentHashCodeTest() {
        // Given two new Instances of a Match
        final Match match1 = newInstance();
        final Match match2 = newInstance();

        // When calling hashCode
        final int hashCode1 = match1.hashCode();
        final int hashCode2 = match2.hashCode();

        // Then the two hashCodes will be different
        Assert.assertNotEquals("The two Matches hash codes are equal when they should not be",
                hashCode1, hashCode2);
    }
}
