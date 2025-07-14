package tdd.exercises.jul.thirteenth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class KarateChopVTest {
    private final KarateChopV karateChopV = new KarateChopV();

    @Test
    void shouldReturnNegativeOne_whenTargetElementDoesNotExistInArray() {
        final int targetElement = 4;
        final int[] array = {1, 2, 3};

        final int indexOfTargetElement = this.karateChopV.find(targetElement, array);

        final int expectedIndex = -1;
        assertEquals(expectedIndex, indexOfTargetElement);
    }

    @Test
    void shouldReturnMiddleIndex_whenTargetElementIsCenterElement() {
        final int targetElement = 2;
        final int[] array = {1, 2, 3};

        final int indexOfTargetElement = this.karateChopV.find(targetElement, array);

        final int expectedIndex = 1;
        assertEquals(expectedIndex, indexOfTargetElement);
    }

    @Test
    void shouldReturnFirstIndex_whenTargetElementIsFirstElement() {
        final int targetElement = 1;
        final int[] array = {1, 2, 3};

        final int indexOfTargetElement = this.karateChopV.find(targetElement, array);

        final int expectedIndex = 0;
        assertEquals(expectedIndex, indexOfTargetElement);
    }

    @Test
    void shouldReturnLastIndex_whenTargetElementIsLastElement() {
        final int targetElement = 3;
        final int[] array = {1, 2, 3};

        final int indexOfTargetElement = this.karateChopV.find(targetElement, array);

        final int expectedIndex = 2;
        assertEquals(expectedIndex, indexOfTargetElement);
    }
}