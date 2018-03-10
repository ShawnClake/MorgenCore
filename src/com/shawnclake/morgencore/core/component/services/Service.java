package com.shawnclake.morgencore.core.component.services;

import com.shawnclake.morgencore.core.component.observers.Observer;
import com.shawnclake.morgencore.core.component.observers.Subject;

import java.util.ArrayList;

/**
 * Service
 * Some globally accessible umbrella type
 * When a service is added or removed, the observers will be notified
 * todo: fix and complete the observer pattern here
 */
abstract public class Service implements Subject {

    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public ArrayList<Observer> getObservers() {
        return this.observers;
    }
}
