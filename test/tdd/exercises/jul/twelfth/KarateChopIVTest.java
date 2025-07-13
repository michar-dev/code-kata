package tdd.exercises.jul.twelfth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class KarateChopIVTest {
    private final KarateChopIV karateChopIV = new KarateChopIV();

    @Test
    void returnZero_whenArrayOnlyContainsTargetElement() {
        final int targetElement = 0;
        final int[] array = {0};

        final int actualIndex = this.karateChopIV.find(targetElement, array);

        final int expectedIndex = 0;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnNegativeOne_whenArrayDoesNotContainTargetElement() {
        final int targetElement = 0;
        final int[] array = {1};

        final int actualIndex = this.karateChopIV.find(targetElement, array);

        final int expectedIndex = -1;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnOne_whenTargetElementIsSecondElement() {
        final int targetElement = 1;
        final int[] array = {0, 1};

        final int actualIndex = this.karateChopIV.find(targetElement, array);

        final int expectedIndex = 1;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnZero_whenTargetElementIsFirstElement() {
        final int targetElement = 0;
        final int[] array = {0, 1};

        final int actualIndex = this.karateChopIV.find(targetElement, array);

        final int expectedIndex = 0;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnTwo_whenTargetElementIsThirdElementOfFourElements() {
        final int targetElement = 2;
        final int[] array = {0, 1, 2, 3};

        final int actualIndex = this.karateChopIV.find(targetElement, array);

        final int expectedIndex = 2;
        assertEquals(expectedIndex, actualIndex);
    }
}