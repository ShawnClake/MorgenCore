package com.shawnclake.morgencore.core.component;

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
}
