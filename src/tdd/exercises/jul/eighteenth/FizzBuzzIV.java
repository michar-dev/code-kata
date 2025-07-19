package tdd.exercises.jul.eighteenth;

public final class FizzBuzzIV {

    public void print(final int number) {
        if (isDivisible(number, 3) && isDivisible(number, 5)) {
            System.out.println("FizzBuzz");
        } else if (isDivisible(number, 3)) {
            System.out.println("Fizz");
        } else if (isDivisible(number, 5)) {
            System.out.println("Buzz");
        } else {
            System.out.println(number);
        }
    }

    private boolean isDivisible(final int dividend, final int divisor) {
        return dividend % divisor == 0;
    }
}
