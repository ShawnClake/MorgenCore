package com.shawnclake.morgencore.core.component;

public class RegexResult extends Results {

    public RegexResult(String match) {
        this.addResult("match", match);
    }

    public RegexResult(String match, int start) {
        this.addResult("start", start);
        this.addResult("match", match);
    }

    public RegexResult(String match, int start, int end) {
        this.addResult("match", match);
        this.addResult("start", start);
        this.addResult("end", end);

        this.addResult("length", end - start);
    }

    public String getMatch() {
        return this.getResult("match").__str__();
    }

    public int getStart() {
        return this.getResult("start").getInt();
    }

    public int getEnd() {
        return this.getResult("end").getInt();
    }

    public int getLength() {
        return this.getResult("length").getInt();
    }
}
