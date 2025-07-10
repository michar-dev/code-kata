package tdd.exercises.jul.ninth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class KarateChopTest {
    private final KarateChop karateChop = new KarateChop();

    @Test
    void shouldReturnNegativeOne_whenTargetElementDoesNotExistInArray() {
        final int targetElement = 4;
        final int[] array = {1, 2, 3};

        final int indexOfTargetElement = this.karateChop.find(targetElement, array);

        final int expectedIndex = -1;
        assertEquals(expectedIndex, indexOfTargetElement);
    }

    @Test
    void shouldReturnMiddleIndex_whenTargetElementIsCenterElement() {
        final int targetElement = 2;
        final int[] array = {1, 2, 3};

        final int indexOfTargetElement = this.karateChop.find(targetElement, array);

        final int expectedIndex = 1;
        assertEquals(expectedIndex, indexOfTargetElement);
    }

    @Test
    void shouldReturnFirstIndex_whenTargetElementIsFirstElement() {
        final int targetElement = 1;
        final int[] array = {1, 2, 3};

        final int indexOfTargetElement = this.karateChop.find(targetElement, array);

        final int expectedIndex = 0;
        assertEquals(expectedIndex, indexOfTargetElement);
    }

    @Test
    void shouldReturnLastIndex_whenTargetElementIsLastElement() {
        final int targetElement = 3;
        final int[] array = {1, 2, 3};

        final int indexOfTargetElement = this.karateChop.find(targetElement, array);

        final int expectedIndex = 2;
        assertEquals(expectedIndex, indexOfTargetElement);
    }
}