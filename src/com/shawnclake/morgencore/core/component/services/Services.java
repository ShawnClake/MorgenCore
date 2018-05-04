package com.shawnclake.morgencore.core.component.services;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Services
 * Collection of all globally accessible services
 */
public class Services extends AdvancedObject {

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

    public void register(Service service)
    {
        if(contains(service.getClass()))
        {
            try {
                throw new Exception("Service is already registered");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        services.add(service);
        service.doNotify();
    }

    public void register(Class serviceClass)
    {
        try {
            Service service = (Service)serviceClass.getDeclaredConstructor().newInstance();
            this.register(service);
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

    public static <T extends Service> T getService(Class<T> serviceClass)
    {
        Services services = instance();

        for(Service service : services.getServices())
        {
            if(service.getClass() == serviceClass)
                return (T)service;
        }

        return null;
    }

    public <T extends Service> T get(Class<T> serviceClass)
    {
        for(Service service : services)
        {
            if(service.getClass() == serviceClass)
                return (T)service;
        }

        return null;
    }

    @Override
    public String __str__() {
        String str = "";
        for(Service service : this.getServices())
        {
            str += service.getName() + " - " + service.getDescription() + "\n" + service.__str__() + "\n" + service.getStateStatistics().__str__()  +  "\n\n";
        }
        return str;
    }
}
