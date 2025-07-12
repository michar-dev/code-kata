package tdd.exercises.jul.eleventh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class KarateChopIIITest {
    private final KarateChopIII karateChopIII = new KarateChopIII();

    @Test
    void returnNegativeOne_whenArrayIsEmpty() {
        final int targetElement = 0;
        final int[] array = {};

        final int actualIndex = this.karateChopIII.findIndexOf(targetElement, array);

        final int expectedIndex = -1;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnZero_whenArrayOnlyContainsTargetElement() {
        final int targetElement = 0;
        final int[] array = {0};

        final int actualIndex = this.karateChopIII.findIndexOf(targetElement, array);

        final int expectedIndex = 0;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnNegativeOne_whenArrayDoesNotContainTargetElement() {
        final int targetElement = 0;
        final int[] array = {1};

        final int actualIndex = this.karateChopIII.findIndexOf(targetElement, array);

        final int expectedIndex = -1;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnOne_whenTargetElementIsSecondElement() {
        final int targetElement = 1;
        final int[] array = {0, 1};

        final int actualIndex = this.karateChopIII.findIndexOf(targetElement, array);

        final int expectedIndex = 1;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnTwo_whenTargetElementIsThirdElement() {
        final int targetElement = 2;
        final int[] array = {0, 1, 2};

        final int actualIndex = this.karateChopIII.findIndexOf(targetElement, array);

        final int expectedIndex = 2;
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    void returnOne_whenTargetElementIsSecondElementOfFourElements() {
        final int targetElement = 1;
        final int[] array = {0, 1, 2, 3};

        final int actualIndex = this.karateChopIII.findIndexOf(targetElement, array);

        final int expectedIndex = 1;
        assertEquals(expectedIndex, actualIndex);
    }
}