package tdd.exercises.jul.fourteenth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class NameInverterTest {
    private final NameInverter nameInverter = new NameInverter();

    @Test
    void returnEmptyString_whenInputIsNull() {
        final String name = null;

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnEmptyString_whenInputIsEmpty() {
        final String name = "";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnEmptyString_whenInputOnlyContainsWhitespace() {
        final String name = "  ";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnInput_whenInputContainsOneName() {
        final String name = "John";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "John";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnInput_whenInputContainsOneNameWithExtraWhitespace() {
        final String name = " John  ";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "John";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnNameInLastCommaFirstForm_whenInputContainsTwoNames() {
        final String name = "John Snow";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "Snow, John";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnNameInLastCommaFirstForm_whenInputContainsTwoNamesWithExtraWhitespace() {
        final String name = "  John   Snow    ";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "Snow, John";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnNameInLastCommaFirstForm_whenInputContainsHonorificAndTwoNames() {
        final String name = "Mr. John Snow";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "Snow, John";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnNameInLastCommaFirstForm_whenInputContainsHonorificAndTwoNamesWithExtraWhitespace() {
        final String name = "  Mr.    John   Snow     ";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "Snow, John";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnNameInLastCommaFirstForm_whenInputContainsTwoNamesAndPostNominal() {
        final String name = "John Snow PhD.";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "Snow, John PhD.";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void returnNameInLastCommaFirstForm_whenInputContainsTwoNamesAndPostNominalWithExtraWhitespace() {
        final String name = " John  Snow   PhD.   ";

        final String actualOutput = this.nameInverter.invert(name);

        final String expectedOutput = "Snow, John PhD.";
        assertEquals(expectedOutput, actualOutput);
    }
}