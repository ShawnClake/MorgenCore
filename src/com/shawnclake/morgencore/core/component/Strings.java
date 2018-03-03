package com.shawnclake.morgencore.core.component;

public class Strings {

    /**
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

    public static String removeLineBreaks(String string)
    {
        String[] lines = string.split("\r\n|\r|\n");

        String oneLiner = "";

        for (String line : lines) {
            oneLiner += line;
        }

        return oneLiner;
    }
}
