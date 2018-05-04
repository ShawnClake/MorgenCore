package com.shawnclake.morgencore.core.component.patterns.observer;

import com.shawnclake.morgencore.core.component.objects.advanced.AdvancedObject;
import com.shawnclake.morgencore.core.component.property.Properties;

import java.util.ArrayList;

/**
 * Subject to observer
 */
public abstract class Subject extends AdvancedObject {

    private ArrayList<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    public void removeObserver(Observer observer)
    {
        observers.remove(observer);
    }

    public ArrayList<Observer> getObservers()
    {
        return observers;
    }

    public void doNotify()
    {
        for(Observer observer : observers)
        {
            observer.update(new Properties());
        }
    }

    public void doNotify(Properties properties)
    {
        for(Observer observer : observers)
        {
            observer.update(properties);
        }
    }
}
