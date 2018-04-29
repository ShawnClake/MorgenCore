package com.shawnclake.morgencore.core.component.events;

import com.shawnclake.morgencore.core.component.reflection.Utilities;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * EventsSystem is used to set up an event handler system
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
 */
public class EventsSystem {

    protected HashMap<String, HashMap<Listener, ArrayList<Method>>> listeners = new HashMap<>();

    /**
     * Registers a listener by passing in a class
     * @param listener
     */
    public void registerListener(Class<?> listener)
    {
        if(Utilities.isObjectImplementing(listener, Listener.class))
        {
            try {
                registerListener((Listener)listener.getDeclaredConstructor().newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Registers a listener by passing in a listener object
     * @param listener
     */
    public void registerListener(Listener listener)
    {
        Method[] methods = listener.getClass().getMethods();

        for(Method method : methods)
        {
            if(method.getParameterCount() != 1)
                continue;

            if(Utilities.isObjectImplementing(method.getParameterTypes()[0], Event.class))
            {
                String event = method.getParameterTypes()[0].getName();

                if(!this.listeners.containsKey(event))
                {
                    this.listeners.put(event, new HashMap<>());
                }

                if(!this.listeners.get(event).containsKey(listener))
                {
                    this.listeners.get(event).put(listener, new ArrayList<>());
                }

                this.listeners.get(event).get(listener).add(method);
            }

            //if(Event.class.isAssignableFrom(method.getParameterTypes()[0]))

            //if(method.getParameterTypes()[0].getGenericInterfaces())
        }

    }

    /**
     * Triggers an event by passing an event object instance
     * @param eventObj
     */
    public void trigger(Event eventObj)
    {
        String event = eventObj.getClass().getName();

        if(this.listeners.containsKey(event))
        {
            for(Map.Entry<Listener, ArrayList<Method>> entry : this.listeners.get(event).entrySet())
            {
                Listener listener = entry.getKey();
                ArrayList<Method> methods = entry.getValue();

                for(Method method : methods)
                {
                    //System.out.println(method.getParameterTypes()[0].getName());
                    //System.out.println(eventObj.getClass().getName());
                    try {
                        method.invoke(listener, eventObj);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            // we dont have any listeners for this event type.. crap!
        }

    }


}
