package tdd.exercises.jul.twelfth;

public final class KarateChopIV {

    public int find(final int targetElement, final int[] array) {
        final int leftIndex = 0;
        final int rightIndex = array.length - 1;
        return find(leftIndex, rightIndex, targetElement, array);
    }

    private int find(final int leftIndex, final int rightIndex, final int targetElement, final int[] array) {
        if (leftIndex > rightIndex) {
            return -1;
        }

        if (array[leftIndex] > targetElement) {
            return -1;
        }

        if (array[rightIndex] < targetElement) {
            return -1;
        }

        final int middleIndex = (leftIndex + rightIndex) / 2;
        if (array[middleIndex] == targetElement) {
            return middleIndex;
        }

        final int leftSearchResult = find(middleIndex + 1, rightIndex, targetElement, array);
        final int rightSearchResult = find(leftIndex, middleIndex - 1, targetElement, array);
        return Math.max(leftSearchResult, rightSearchResult);
    }
}
