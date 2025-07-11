package tdd.exercises.jul.tenth;

public final class KarateChopII {

    public int find(final int targetElement, final int[] array) {
        final int leftIdx = 0;
        final int rightIdx = array.length - 1;
        return chop(leftIdx, rightIdx, targetElement, array);
    }

    private int chop(final int leftIdx, final int rightIdx, final int targetElement, final int[] array) {
        if (leftIdx > rightIdx) {
            return -1;
        }

        final int middleIdx = (leftIdx + rightIdx) / 2;
        if (array[middleIdx] == targetElement) {
            return middleIdx;
        }

        if (array[middleIdx] < targetElement) {
            final int nextLeftIdx = leftIdx + 1;
            return chop(nextLeftIdx, rightIdx, targetElement, array);
        }

        if (array[middleIdx] > targetElement) {
            final int nextRightIdx = rightIdx - 1;
            return chop(leftIdx, nextRightIdx, targetElement, array);
        }

        return -1;
    }
}
