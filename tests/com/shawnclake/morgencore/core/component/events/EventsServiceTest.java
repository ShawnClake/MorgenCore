package com.shawnclake.morgencore.core.component.events;

import com.shawnclake.morgencore.core.component.interactables.InteractableService;
import com.shawnclake.morgencore.core.component.services.Services;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventsServiceTest {

    @Test
    void registerListener() {
        EventsService eventsService = new EventsService();
        eventsService.registerListener(new TestListener());
        new InteractableService();
        System.out.println(Services.instance().__str__());
    }

    @Test
    void trigger() {
        EventsService eventsService = new EventsService();
        eventsService.registerListener(new TestListener());
        eventsService.trigger(new TestEvent2());
        eventsService.registerListener(TestListener2.class);
        eventsService.trigger(new TestEvent());

        EventsSystem eventsSystem = new EventsSystem();
        eventsSystem.registerListener(new TestListener());

        eventsService.trigger(new TestEvent3(73));
        eventsSystem.trigger(new TestEvent3(73));

        System.out.println(Services.instance().__str__());
    }
}