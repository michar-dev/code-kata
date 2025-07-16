package tdd.exercises.jul.fifteenth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

final class NameInverterIITest {
    private final NameInverterII nameInverterII = new NameInverterII();

    @Test
    void returnEmptyString_whenNameIsNull() {
        final String name = null;

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnEmptyString_whenNameIsEmpty() {
        final String name = "";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnEmptyString_whenNameOnlyContainsWhitespace() {
        final String name = "   ";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnName_whenNameOnlyContainsOnePart() {
        final String name = "Joe";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "Joe";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnName_whenNameContainsOnePartWithExtraWhitespace() {
        final String name = " Joe ";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "Joe";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnLastCommaFirst_whenNameOnlyContainsTwoParts() {
        final String name = "Joe Jack";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "Jack, Joe";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnLastCommaFirst_whenNameContainsTwoPartsWithExtraWhitespace() {
        final String name = " Joe  Jack  ";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "Jack, Joe";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnLastCommaFirst_whenNameContainsHonorific() {
        final String name = "Mr. Joe Jack";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "Jack, Joe";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnLastCommaFirst_whenNameContainsHonorificWithExtraSpace() {
        final String name = " Mr.  Joe  Jack  ";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "Jack, Joe";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnLastCommaFirst_whenNameContainsPostNominal() {
        final String name = "Joe Jack PhD";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "Jack, Joe PhD";
        assertEquals(expectedNameInversion, actualNameInversion);
    }

    @Test
    void returnLastCommaFirst_whenNameContainsPostNominalWithExtraWhitespace() {
        final String name = " Joe   Jack   PhD   ";

        final String actualNameInversion = this.nameInverterII.invert(name);

        final String expectedNameInversion = "Jack, Joe PhD";
        assertEquals(expectedNameInversion, actualNameInversion);
    }
}