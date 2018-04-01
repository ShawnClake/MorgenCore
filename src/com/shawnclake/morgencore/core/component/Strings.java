package com.shawnclake.morgencore.core.component;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Helper string methods
 * todo: move the line break regex into the symbols class and then reference it here
 */
public class Strings {

    /**
     * Takes a String s in camel class and splits it by injecting a space
     * Taken from polygenelubricants answer on
     * https://stackoverflow.com/questions/2559759/how-do-i-convert-camelcase-into-human-readable-names-in-java
     * @param s
     * @return
     */
    public static String splitCamelCase(String s) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ),
                " "
        );
    }

    /**
     * Takes a String s in camel class and splits it by injecting the supplied replacement
     * Taken from polygenelubricants answer on
     * https://stackoverflow.com/questions/2559759/how-do-i-convert-camelcase-into-human-readable-names-in-java
     * @param s
     * @return
     */
    public static String splitCamelCase(String s, String replacement) {
        return s.replaceAll(
                String.format("%s|%s|%s",
                        "(?<=[A-Z])(?=[A-Z][a-z])",
                        "(?<=[^A-Z])(?=[A-Z])",
                        "(?<=[A-Za-z])(?=[^A-Za-z])"
                ), replacement
        );
    }

    /**
     * Removes all line break characters from a supplied string
     * @param string
     * @return
     */
    public static String removeLineBreaks(String string)
    {
        String[] lines = string.split("\r\n|\r|\n");

        String oneLiner = "";

        for (String line : lines) {
            oneLiner += line;
        }

        return oneLiner;
    }

    /**
     * Counts the number of occurences of a char within a string
     * Taken from Jon Skeets answer from
     * https://stackoverflow.com/questions/275944/java-how-do-i-count-the-number-of-occurrences-of-a-char-in-a-string
     * @param haystack
     * @param needle
     * @return
     */
    public static int countOccurrences(String haystack, char needle)
    {
        int count = 0;
        for (int i=0; i < haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * Prints to console the occurences of each regex match within a string of text
     *
     * Taken from Jean Logeart's answer from
     * https://stackoverflow.com/questions/8938498/get-the-index-of-a-pattern-in-a-string-using-regex
     * @param text
     * @param regex
     */
    public static void printMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        // Check all occurrences
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end());
            System.out.println(" Found: " + matcher.group());
        }
    }

    /**
     * Returns all the RegexResult objects for regex matches within a string
     * @param text
     * @param regex
     * @return
     */
    public static ArrayList<RegexResult> getMatches(String text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        // Check all occurrences

        ArrayList<RegexResult> results = new ArrayList<>();

        while (matcher.find()) {
            results.add(new RegexResult(matcher.group(), matcher.start(), matcher.end()));
            //System.out.print("Start index: " + matcher.start());
            //System.out.print(" End index: " + matcher.end());
            //System.out.println(" Found: " + matcher.group());
        }

        return results;
    }

    /**
     * Taken from CraigTP's answer on StackOverflow
     * https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
     *
     * Works for negative and decimal numbers but not international
     *
     * @param str
     * @return
     */
    public static boolean isNumericRegex(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    /**
     * Taken from CraigTP's answer on StackOverflow
     * https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
     * @param str
     * @return
     */
    public static boolean isNumericInternational(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    /**
     * Taken from CraigTP's answer on StackOverflow
     * https://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
     *
     * Does not work for numbers that are negative or decimals
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str)
    {
        return str.chars().allMatch( Character::isDigit );
    }
}
