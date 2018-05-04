package com.shawnclake.morgencore.core.component.services;

import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;
import com.shawnclake.morgencore.core.component.patterns.observer.Subject;
import com.shawnclake.morgencore.core.component.property.Properties;

/**
 * Service
 * Some globally accessible umbrella type
 * When a service is added or removed, the observers will be notified
 * todo: fix and complete the observer pattern here
 */
abstract public class Service extends Subject {

    public Service() {
        if(this.registerAutomatically())
            Services.instance().register(this);
    }

    public Service get()
    {
        return Services.instance().get(this.getClass());
    }

    protected boolean registerAutomatically()
    {
        return true;
    }

    public String getName()
    {
        return this.getClass().getSimpleName();
    }

    public String getFullName()
    {
        return this.getClass().getName();
    }

    public String getDescription()
    {
        return "This service has no description";
    }

    @SuppressWarnings("unchecked")
    public Properties getStateStatistics()
    {
        return new Properties().add("default", new LazyDynamicPrimitive("This Service does not have any state statistics"));
    }

}
