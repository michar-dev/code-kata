package tdd.exercises.jul.eighth;

public final class LeapYear {

    public boolean validate(final int year) {
        if (isDivisibleByOneHundred(year)) {
            return isDivisibleByFourHundred(year);
        } else {
            return isDivisibleByFour(year);
        }
    }

    private boolean isDivisibleByOneHundred(final int number) {
        return number % 100 == 0;
    }

    private boolean isDivisibleByFourHundred(final int number) {
        return number % 400 == 0;
    }

    private boolean isDivisibleByFour(final int number) {
        return number % 4 == 0;
    }
}
