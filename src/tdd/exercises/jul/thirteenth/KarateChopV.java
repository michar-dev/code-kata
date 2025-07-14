package tdd.exercises.jul.thirteenth;

public final class KarateChopV {

    public int find(final int targetElement, final int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        while (leftIndex <= rightIndex) {
            if (leftIndex == rightIndex && array[leftIndex] != targetElement) {
                return -1;
            }

            if (leftIndex == rightIndex && array[leftIndex] == targetElement) {
                return leftIndex;
            }

            final int middleIndex = (leftIndex + rightIndex) / 2;
            final double indexScalar = (double) array[middleIndex] / (array[leftIndex] + array[rightIndex]);
            final int scaledMiddleIndex = (int) (rightIndex * indexScalar);
            if (array[scaledMiddleIndex] == targetElement) {
                return scaledMiddleIndex;
            } else if (array[scaledMiddleIndex] < targetElement) {
                leftIndex = scaledMiddleIndex + 1;
            } else {
                rightIndex = scaledMiddleIndex - 1;
            }
        }

        return -1;
    }
}
