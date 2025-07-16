package tdd.exercises.jul.fifteenth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class NameInverterII {
    private static final Pattern ONE_PART_NAME_PATTERN = Pattern.compile("^\\s*(?<name>[a-zA-Z]+)\\s*$");
    private static final Pattern TWO_PART_NAME_PATTERN = Pattern.compile("^\\s*(?<firstName>[a-zA-Z]+)\\s+(?<lastName>[a-zA-Z]+)\\s*$");
    private static final Pattern NAME_WITH_HONORIFIC_PATTERN = Pattern.compile("^\\s*(?<honorific>[a-zA-Z]+[.])\\s+(?<firstName>[a-zA-Z]+)\\s+(?<lastName>[a-zA-Z]+)\\s*$");
    private static final Pattern NAME_WITH_POST_NOMINAL_PATTERN = Pattern.compile("^\\s*(?<firstName>[a-zA-Z]+)\\s+(?<lastName>[a-zA-Z]+)\\s+(?<postNominal>[a-zA-Z]+)\\s*$");

    public String invert(final String name) {
        return (this.validate(name))
                ? convertNameToLastCommaFirst(name)
                : createEmptyString();
    }

    private boolean validate(final String name) {
        return name != null && !name.matches("^\\s*$");
    }

    private String convertNameToLastCommaFirst(final String name) {
        final Matcher onePartNameMatcher = ONE_PART_NAME_PATTERN.matcher(name);
        if (onePartNameMatcher.find()) {
            return name.trim();
        }

        final Matcher twoPartNameMatcher = TWO_PART_NAME_PATTERN.matcher(name);
        if (twoPartNameMatcher.find()) {
            final String firstName = twoPartNameMatcher.group("firstName");
            final String lastName = twoPartNameMatcher.group("lastName");
            return lastName + ", " + firstName;
        }

        final Matcher nameWithHonorificMatcher = NAME_WITH_HONORIFIC_PATTERN.matcher(name);
        if (nameWithHonorificMatcher.find()) {
            final String firstName = nameWithHonorificMatcher.group("firstName");
            final String lastName = nameWithHonorificMatcher.group("lastName");
            return lastName + ", " + firstName;
        }

        final Matcher nameWithPostNominalMatcher = NAME_WITH_POST_NOMINAL_PATTERN.matcher(name);
        if (nameWithPostNominalMatcher.find()) {
            final String firstName = nameWithPostNominalMatcher.group("firstName");
            final String lastName = nameWithPostNominalMatcher.group("lastName");
            final String postNominal = nameWithPostNominalMatcher.group("postNominal");
            return lastName + ", " + firstName + " " + postNominal;
        }

        return "";
    }

    private String createEmptyString() {
        return "";
    }
}
