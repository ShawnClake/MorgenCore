package com.shawnclake.morgencore.core.component.observers;

import java.util.ArrayList;

public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    ArrayList<Observer> getObservers();

    void doNotify();
}
