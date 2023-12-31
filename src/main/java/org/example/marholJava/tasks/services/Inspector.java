package org.example.marholJava.tasks.services;

public class Inspector {

    private static final String REGEX_FOR_Q_LETTER = "[Qq]";

    public boolean checkForExitRequest(String string) {
        return checkIfRegexMatches(string, REGEX_FOR_Q_LETTER);
    }

    public boolean checkIfRegexMatches(String string, String regex) {
        return string.matches(regex);
    }
}