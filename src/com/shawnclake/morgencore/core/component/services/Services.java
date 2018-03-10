package com.shawnclake.morgencore.core.component.services;

import java.util.ArrayList;

/**
 * Services
 * Collection of all globally accessible services
 */
public class Services {

    private ArrayList<Service> services = new ArrayList<>();

    public void create(Service service)
    {
        services.add(service);
    }

    public  boolean contains(Class serviceClass)
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

    public <T extends Service> T getSerivce(Class<T> serviceClass)
    {
        for(Service service : services)
        {
            if(service.getClass() == serviceClass)
                return (T)service;
        }

        return null;
    }

}
