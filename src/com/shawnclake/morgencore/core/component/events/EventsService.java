package com.shawnclake.morgencore.core.component.events;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Events Service is used to setup a globally accessible event handler system
 *
 * Lightweight dynamic Events system
 *
 * Create listener classes by implementing the Listener interface
 * Create event classes by implementing the event interface
 *
 * Register listeners during the application loading process by passing an instance of the listener
 * class to registerListener
 *
 * Trigger events on all registered listeners by calling the trigger method and passing the event instance
 *
 * Create handler methods in listeners by creating methods with arbitrary return types and names
 *   As long as they contain exactly a single parameter of the event type, it will be triggered on event
 *
 * Singleton class with application wide access. Thus, it is not possible to create multiple event services.
 * This means all events will be able to hooked in to regardless of where/why. This may not be desirable behaviour.
 *
 */
public class EventsService {

    private static EventsService instance = null; // Singleton instance

    private EventsSystem eventsSystem = new EventsSystem();

    protected EventsService() {
        // Exists only to defeat instantiation.
    }

    /**
     * Returns the singleton instance
     * @return
     */
    public static EventsService instance()
    {
        if(instance == null)
            instance = new EventsService();
        return instance;
    }

    public static void registerListener(Class<?> listener) {
        EventsService eventsService = instance();
        eventsService.eventsSystem.registerListener(listener);
    }

    public static void registerListener(Listener listener) {
        EventsService eventsService = instance();
        eventsService.eventsSystem.registerListener(listener);
    }

    public static void trigger(Event eventObj) {
        EventsService eventsService = instance();
        eventsService.eventsSystem.trigger(eventObj);
    }

    public static void registerEventsSystem(EventsSystem eventsSystem)
    {
        for(HashMap<Listener, ArrayList<Method>> event : eventsSystem.listeners.values())
        {
            for(Listener listener : event.keySet())
            {
                registerListener(listener);
            }
        }
    }
}
