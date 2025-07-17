package tdd.exercises.jul.sixteenth;

import java.util.List;

public final class FizzBuzzII {
    private static final List<NumberMapping> NUMBER_MAPPINGS = List.of(
            new NumberMapping(3, "Fizz"),
            new NumberMapping(5, "Buzz")
    );

    public void print(final int number) {
        final String output = this.buildOutput(number);
        if (output.isEmpty()) {
            System.out.println(number);
        } else {
            System.out.println(output);
        }
    }

    private String buildOutput(final int number) {
        StringBuilder outputStringBuilder = new StringBuilder();

        for (final NumberMapping numberMapping : NUMBER_MAPPINGS) {
            if (isDivisible(number, numberMapping.number)) {
                outputStringBuilder.append(numberMapping.string);
            }
        }

        return outputStringBuilder.toString();
    }

    private static boolean isDivisible(final int dividend, final int divisor) {
        return dividend % divisor == 0;
    }

    private record NumberMapping(int number, String string) {

    }
}
