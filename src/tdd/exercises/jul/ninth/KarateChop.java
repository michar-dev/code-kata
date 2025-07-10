package tdd.exercises.jul.ninth;

public final class KarateChop {

    public int find(final int targetElement, final int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            final int middle = (left + right) / 2;
            if (array[middle] == targetElement) {
                return middle;
            } else if (array[middle] < targetElement) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }
}
