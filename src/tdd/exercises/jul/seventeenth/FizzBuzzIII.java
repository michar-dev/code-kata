package tdd.exercises.jul.seventeenth;

import java.util.HashMap;
import java.util.Map;

public final class FizzBuzzIII {
    private final static Map<Integer, String> integerToStringMap = initializeIntegerToStringMap();

    private static Map<Integer, String> initializeIntegerToStringMap() {
        final Map<Integer, String> integerStringHashMap = new HashMap<>();
        integerStringHashMap.put(3, "Fizz");
        integerStringHashMap.put(5, "Buzz");
        return integerStringHashMap;
    }

    public void print(final int number) {
        String output = tryToConvertToString(number);

        if (output.isEmpty()) {
            output += number;
        }

        System.out.println(output);
    }

    private String tryToConvertToString(final int number) {
        final StringBuilder outputBuilder = new StringBuilder();

        for (final int divisor : integerToStringMap.keySet()) {
            if (isDivisible(number, divisor)) {
                final String string = integerToStringMap.get(divisor);
                outputBuilder.append(string);
            }
        }

        return outputBuilder.toString();
    }

    private static boolean isDivisible(final int number, final int divisor) {
        return number % divisor == 0;
    }
}
