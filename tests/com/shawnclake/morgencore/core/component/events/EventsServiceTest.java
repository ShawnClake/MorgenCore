package com.shawnclake.morgencore.core.component.events;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventsServiceTest {

    @Test
    void registerListener() {
        EventsService.registerListener(new TestListener());
    }

    @Test
    void trigger() {
        EventsService.registerListener(new TestListener());
        EventsService.trigger(new TestEvent2());
        EventsService.registerListener(TestListener2.class);
        EventsService.trigger(new TestEvent());
    }
}