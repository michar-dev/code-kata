package tdd.exercises.jul.thirtieth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingGameKataTest {

    @Test
    void getScoreFromFrame_shouldReturnNegativeOne_whenOnFirstRoll() {
        final int frameIndex = 0;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        final int actualScore = bowlingGameKata.getScoreFromFrame(frameIndex);

        final int expectedScore = -1;
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void getScoreFromFrame_shouldReturnZero_whenFirstRollScoredZero() {
        final int frameIndex = 0;
        final int firstRollScore = 0;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        bowlingGameKata.roll(firstRollScore);
        final int actualScore = bowlingGameKata.getScoreFromFrame(frameIndex);

        final int expectedScore = 0;
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void getScoreFromFrame_shouldReturnTwo_whenFirstRollScoredTwo() {
        final int frameIndex = 0;
        final int firstRollScore = 2;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        bowlingGameKata.roll(firstRollScore);
        final int actualScore = bowlingGameKata.getScoreFromFrame(frameIndex);

        final int expectedScore = 2;
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void getScoreFromFrame_shouldReturnFive_whenFirstRollScoredTwoAndSecondRollScoredThree() {
        final int frameIndex = 0;
        final int firstRollScore = 2;
        final int secondRollScore = 3;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        bowlingGameKata.roll(firstRollScore);
        bowlingGameKata.roll(secondRollScore);
        final int actualScore = bowlingGameKata.getScoreFromFrame(frameIndex);

        final int expectedScore = 5;
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void getScoreFromFrame_shouldReturnThirteen_whenFirstFrameScoredSpareAndNextRollScoredThree() {
        final int frameIndex = 0;
        final int firstRollScore = 5;
        final int secondRollScore = 5;
        final int thirdRollScore = 3;
        final int fourthRoll = 3;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        bowlingGameKata.roll(firstRollScore);
        bowlingGameKata.roll(secondRollScore);
        bowlingGameKata.roll(thirdRollScore);
        bowlingGameKata.roll(fourthRoll);
        final int actualScore = bowlingGameKata.getScoreFromFrame(frameIndex);

        final int expectedScore = 13;
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void getScoreFromFrame_shouldReturnThirteen_whenFirstFrameScoredStrikeAndSecondFrameScoredThree() {
        final int frameIndex = 0;
        final int firstRollScore = 10;
        final int secondRollScore = 1;
        final int thirdRollScore = 2;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        bowlingGameKata.roll(firstRollScore);
        bowlingGameKata.roll(secondRollScore);
        bowlingGameKata.roll(thirdRollScore);
        final int actualScore = bowlingGameKata.getScoreFromFrame(frameIndex);

        final int expectedScore = 13;
        assertEquals(expectedScore, actualScore);
    }

    @Test
    void canRoll_shouldReturnTrue_whenGameStarted() {
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        assertTrue(bowlingGameKata.canRoll());
    }

    @Test
    void canRoll_shouldReturnTrue_whenFewRollsHaveBeenScored() {
        final int firstRollScore = 10;
        final int secondRollScore = 1;
        final int thirdRollScore = 2;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        bowlingGameKata.roll(firstRollScore);
        bowlingGameKata.roll(secondRollScore);
        bowlingGameKata.roll(thirdRollScore);

        assertTrue(bowlingGameKata.canRoll());
    }

    @Test
    void canRoll_shouldReturnFalse_whenLastFrameDoesNotHaveSpareOrStrike() {
        final int scoreForAllRolls = 0;
        final int maxNumberOfRolls = 20;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        for (int i = 0; i < maxNumberOfRolls; i++) {
            bowlingGameKata.roll(scoreForAllRolls);
        }

        assertFalse(bowlingGameKata.canRoll());
    }

    @Test
    void canRoll_shouldReturnTrue_whenLastFrameHasSpareAndExtraFrameIsOnFirstRoll() {
        final int firstRollScoreForLastFrame = 5;
        final int secondRollScoreForLastFrame = 5;
        final BowlingGameKata bowlingGameKata = getBowlingGameOnLastFrame();

        bowlingGameKata.roll(firstRollScoreForLastFrame);
        bowlingGameKata.roll(secondRollScoreForLastFrame);

        assertTrue(bowlingGameKata.canRoll());
    }

    @Test
    void canRoll_shouldReturnFalse_whenLastFrameHasSpareAndExtraFrameIsNotOnFirstRoll() {
        final int firstRollScoreForLastFrame = 5;
        final int secondRollScoreForLastFrame = 5;
        final int scoreForExtraRole = 3;
        final BowlingGameKata bowlingGameKata = getBowlingGameOnLastFrame();

        bowlingGameKata.roll(firstRollScoreForLastFrame);
        bowlingGameKata.roll(secondRollScoreForLastFrame);
        bowlingGameKata.roll(scoreForExtraRole);

        assertFalse(bowlingGameKata.canRoll());
    }

    @Test
    void canRoll_shouldReturnTrue_whenLastFrameHasStrikeAndExtraFrameIsOnFirstRoll() {
        final int firstRollScoreForLastFrame = 10;
        final BowlingGameKata bowlingGameKata = getBowlingGameOnLastFrame();

        bowlingGameKata.roll(firstRollScoreForLastFrame);

        assertTrue(bowlingGameKata.canRoll());
    }

    @Test
    void canRoll_shouldReturnTrue_whenLastFrameHasStrikeAndExtraFrameIsOnSecondRoll() {
        final int firstRollScoreForLastFrame = 10;
        final int firstRollScoreForExtraFrame = 3;
        final BowlingGameKata bowlingGameKata = getBowlingGameOnLastFrame();

        bowlingGameKata.roll(firstRollScoreForLastFrame);
        bowlingGameKata.roll(firstRollScoreForExtraFrame);

        assertTrue(bowlingGameKata.canRoll());
    }

    @Test
    void canRoll_shouldReturnFalse_whenLastFrameHasStrikeAndExtraFrameIsComplete() {
        final int firstRollScoreForLastFrame = 10;
        final int firstRollScoreForExtraFrame = 10;
        final BowlingGameKata bowlingGameKata = getBowlingGameOnLastFrame();

        bowlingGameKata.roll(firstRollScoreForLastFrame);
        bowlingGameKata.roll(firstRollScoreForExtraFrame);

        assertFalse(bowlingGameKata.canRoll());
    }

    private BowlingGameKata getBowlingGameOnLastFrame() {
        final int scoreForAllAutomatedRolls = 0;
        final int numberOfAutomatedRolls = 18;
        final BowlingGameKata bowlingGameKata = new BowlingGameKata();

        for (int i = 0; i < numberOfAutomatedRolls; i++) {
            bowlingGameKata.roll(scoreForAllAutomatedRolls);
        }

        return bowlingGameKata;
    }
}