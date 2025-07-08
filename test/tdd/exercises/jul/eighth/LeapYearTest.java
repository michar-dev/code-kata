package tdd.exercises.jul.eighth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class LeapYearTest {
    private final LeapYear leapYear = new LeapYear();

    @Test
    void shouldReturnFalse_whenYearIsNotDivisibleByFour() {
        final int year = 1997;

        assertFalse(leapYear.validate(year));
    }

    @Test
    void shouldReturnTrue_whenYearIsDivisibleByFour() {
        final int year = 1996;

        assertTrue(leapYear.validate(year));
    }

    @Test
    void shouldReturnFalse_whenYearIsDivisibleByOneHundredAndNotByFourHundred() {
        final int year = 1800;

        assertFalse(leapYear.validate(year));
    }
}