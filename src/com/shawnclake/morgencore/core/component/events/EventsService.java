package com.shawnclake.morgencore.core.component.events;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;
import com.shawnclake.morgencore.core.component.property.Properties;
import com.shawnclake.morgencore.core.component.services.Service;

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
public class EventsService extends Service {

    private EventsSystem eventsSystem = new EventsSystem();

    public void registerListener(Class<?> listener) {
        eventsSystem.registerListener(listener);
    }

    public void registerListener(Listener listener) {
        eventsSystem.registerListener(listener);
    }

    public void trigger(Event eventObj) {
        eventsSystem.trigger(eventObj);
    }

    public void registerEventsSystem(EventsSystem eventsSystem)
    {
        for(HashMap<Listener, ArrayList<Method>> event : eventsSystem.listeners.values())
        {
            for(Listener listener : event.keySet())
            {
                registerListener(listener);
            }
        }
    }

    @Override
    public String getDescription() {
        return "Globally accessible events system";
    }

    @Override
    public Properties getStateStatistics() {
        return new Properties().add("Event Handlers", new LazyDynamicPrimitive<>(this.eventsSystem.listeners.size()));//.add("Listener Objs", new LazyDynamicPrimitive<>(this.eventsSystem.listeners.toString()));
    }
}
