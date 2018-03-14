package com.shawnclake.morgencore.core.component;

public class RegexResult {

    private String match;

    private int start;

    private int end;

    private int length;

    public RegexResult(String match) {
        this.match = match;
    }

    public RegexResult(String match, int start) {
        this.start = start;
        this.match = match;
    }

    public RegexResult(String match, int start, int end) {
        this.match = match;
        this.start = start;
        this.end = end;

        this.length = end - start;
    }

    public String getMatch() {
        return match;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getLength() {
        return length;
    }
}
