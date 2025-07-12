package tdd.exercises.jul.eleventh;

import java.util.Arrays;

public final class KarateChopIII {

    public int findIndexOf(final int targetElement, final int[] array) {
        if (array.length == 0) {
            return -1;
        }

        if (array.length == 1) {
            return array[0] == targetElement ? 0 : -1;
        }

        final int[] firstArrayPartition = Arrays.copyOfRange(array, 0, array.length / 2);
        if (firstArrayPartition[firstArrayPartition.length - 1] >= targetElement) {
            final int partitionIndex = this.findIndexOf(targetElement, firstArrayPartition);
            return partitionIndex;
        }

        final int[] secondArrayPartition = Arrays.copyOfRange(array, array.length / 2, array.length);
        if (secondArrayPartition[0] <= targetElement) {
            final int partitionIndex = this.findIndexOf(targetElement, secondArrayPartition);
            return (partitionIndex == -1)
                    ? -1
                    : partitionIndex + firstArrayPartition.length;
        }

        return -1;
    }
}
