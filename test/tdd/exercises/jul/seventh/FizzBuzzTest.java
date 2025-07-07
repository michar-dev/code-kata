package tdd.exercises.jul.seventh;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class FizzBuzzTest {
    private final PrintStream defaultOut = System.out;
    private final ByteArrayOutputStream testByteArrayOutputStream = new ByteArrayOutputStream();
    private final PrintStream testOut = new PrintStream(testByteArrayOutputStream);
    private final FizzBuzz fizzBuzz = new FizzBuzz();

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
        final int number = 1;

        fizzBuzz.print(number);

        final String expectedPrintedString = "1\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }

    @Test
    void printGivenNumber_whenGivenNumberIsNotDivisibleByThreeOrFive() {
        final int number = 2;

        fizzBuzz.print(number);

        final String expectedPrintedString = "2\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }

    @Test
    void printFizz_whenGivenNumberIsDivisibleByThree() {
        final int number = 3;

        fizzBuzz.print(number);

        final String expectedPrintedString = "Fizz\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }

    @Test
    void printBuzz_whenGivenNumberIsDivisibleByFive() {
        final int number = 5;

        fizzBuzz.print(number);

        final String expectedPrintedString = "Buzz\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }

    @Test
    void printBuzz_whenGivenNumberIsDivisibleByThreeAndFive() {
        final int number = 15;

        fizzBuzz.print(number);

        final String expectedPrintedString = "FizzBuzz\n";
        final String actualPrintedString = testByteArrayOutputStream.toString();
        assertEquals(expectedPrintedString, actualPrintedString);
    }
}