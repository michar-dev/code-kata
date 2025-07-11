package tdd.exercises.jul.tenth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class KarateChopIITest {
    private final KarateChopII karateChopII = new KarateChopII();

    @Test
    void returnNegativeOne_whenElementDoesNotExist() {
        final int targetElement = 3;
        final int[] array = {1};

        final int actualIndex = this.karateChopII.find(targetElement, array);

        final int expectedIndex = -1;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnZero_whenArrayOnlyContainsTargetElement() {
        final int targetElement = 1;
        final int[] array = {1};

        final int actualIndex = this.karateChopII.find(targetElement, array);

        final int expectedIndex = 0;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnOne_whenTargetElementIsSecondElement() {
        final int targetElement = 1;
        final int[] array = {0, 1};

        final int actualIndex = this.karateChopII.find(targetElement, array);

        final int expectedIndex = 1;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnZero_whenTargetElementIsFirstElement() {
        final int targetElement = 0;
        final int[] array = {0, 1};

        final int actualIndex = this.karateChopII.find(targetElement, array);

        final int expectedIndex = 0;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnZero_whenTargetElementIsFirstElementOfFourElements() {
        final int targetElement = 0;
        final int[] array = {0, 1, 2, 4};

        final int actualIndex = this.karateChopII.find(targetElement, array);

        final int expectedIndex = 0;
        assertEquals(expectedIndex, actualIndex);
    }
}