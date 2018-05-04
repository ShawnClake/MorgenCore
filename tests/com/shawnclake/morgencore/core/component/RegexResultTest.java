package com.shawnclake.morgencore.core.component;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegexResultTest {

    @Test
    void testJsonAndOutput() {

        RegexResult regexResult = new RegexResult("the blah is in the basement", 5, 55);
        System.out.println(regexResult.__str__());
        System.out.println(regexResult.__json__());

    }
}