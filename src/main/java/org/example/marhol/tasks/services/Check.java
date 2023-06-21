package org.example.marhol.tasks.services;

public class Check {

    public boolean checkForExitSignal(String string) {
        return (string.equals("Q") || string.equals("q"));
    }

    public boolean checkIfANumber(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkIfRegexMatches(String string, String regex) {
        return string.matches(regex) || checkForExitSignal(string);
    }
}