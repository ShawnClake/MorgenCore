package com.shawnclake.morgencore.core.component.events;

public class TestEvent3 implements Event {

    private int test;

    public TestEvent3(int test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return test+"";
    }
}
