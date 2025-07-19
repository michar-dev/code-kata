package tdd.exercises.jul.eighteenth;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

final class FizzBuzzIVTest {
    private final PrintStream defaultOut = System.out;
    private final ByteArrayOutputStream testByteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream testOut = new PrintStream(testByteArrayOutputStream);
    private final FizzBuzzIV fizzBuzzIV = new FizzBuzzIV();

    @BeforeEach
    void setUp() {
        System.setOut(testOut);
    }

    @AfterEach
    void tearDown() {
        System.setOut(defaultOut);
        testByteArrayOutputStream.reset();
    }

    @Test
    void printNumber_whenNumberIsNotDivisibleByThreeOrFive() {
        final int number = 2;

        this.fizzBuzzIV.print(number);

        final String expectedPrintedString = "2\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }

    @Test
    void printFizz_whenNumberIsDivisibleByThree() {
        final int number = 3;

        this.fizzBuzzIV.print(number);

        final String expectedPrintedString = "Fizz\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }

    @Test
    void printBuzz_whenNumberIsDivisibleByFive() {
        final int number = 5;

        this.fizzBuzzIV.print(number);

        final String expectedPrintedString = "Buzz\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }

    @Test
    void printFizzBuzz_whenNumberIsDivisibleByThreeAndFive() {
        final int number = 15;

        this.fizzBuzzIV.print(number);

        final String expectedPrintedString = "FizzBuzz\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }
}