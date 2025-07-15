package tdd.exercises.jul.fourteenth;

public final class NameInverter {

    public String invert(final String name) {
        if (name == null) {
            return "";
        }

        final String[] nameParts = getNamePartsFrom(name);
        if (nameParts.length == 1) {
            final String singleName = nameParts[0];
            return singleName;
        } else {
            final String lastCommaFirstForm = createLastCommaFirstFormWith(nameParts);
            return lastCommaFirstForm;
        }
    }

    private static String createLastCommaFirstFormWith(final String[] nameParts) {
        final String lastCommaFirstForm;
        if (nameParts.length < 3) {
            lastCommaFirstForm = createLastCommaFirstWithTwoParts(nameParts);
        } else {
            lastCommaFirstForm = createLastCommaFirstWithThreeParts(nameParts);
        }

        return lastCommaFirstForm;
    }

    private static String createLastCommaFirstWithTwoParts(final String[] nameParts) {
        final String firstName = nameParts[0];
        final String lastName = nameParts[1];
        final String lastCommaFirstForm = lastName + ", " + firstName;
        return lastCommaFirstForm;
    }

    private static String createLastCommaFirstWithThreeParts(final String[] nameParts) {
        final String lastCommaFirstForm;
        if (foundPostNominal(nameParts)) {
            final String firstName = nameParts[0];
            final String lastName = nameParts[1];
            final String postNominal = nameParts[2];
            lastCommaFirstForm = lastName + ", " + firstName + " " + postNominal;
        } else {
            final String firstName = nameParts[1];
            final String lastName = nameParts[2];
            lastCommaFirstForm = lastName + ", " + firstName;
        }

        return lastCommaFirstForm;
    }

    private static boolean foundPostNominal(final String[] nameParts) {
        return nameParts[2].contains(".");
    }

    private String[] getNamePartsFrom(final String name) {
        final String trimmedName = name.trim();
        final String[] nameParts = trimmedName.split("\\s+");
        return nameParts;
    }
}
