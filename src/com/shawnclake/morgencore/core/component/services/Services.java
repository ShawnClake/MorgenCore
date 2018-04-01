package com.shawnclake.morgencore.core.component.services;

import java.util.ArrayList;

/**
 * Services
 * Collection of all globally accessible services
 */
public class Services {

    private ArrayList<Service> services = new ArrayList<>();

    private static Services instance = null;

    protected Services() {
        // Exists only to defeat instantiation.
    }

    public static Services instance()
    {
        if(instance == null)
            instance = new Services();
        return instance;
    }

    public void create(Service service)
    {
        services.add(service);
        service.doNotify();
    }

    public boolean contains(Class serviceClass)
    {
        for(Service service : services)
        {
            if(service.getClass() == serviceClass)
                return true;
        }

        return false;
    }

    public ArrayList<Service> getServices()
    {
        return services;
    }

    public <T extends Service> T getService(Class<T> serviceClass)
    {
        for(Service service : services)
        {
            if(service.getClass() == serviceClass)
                return (T)service;
        }

        return null;
    }

}
