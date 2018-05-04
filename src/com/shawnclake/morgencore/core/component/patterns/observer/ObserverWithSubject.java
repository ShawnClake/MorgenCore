package com.shawnclake.morgencore.core.component.patterns.observer;

import com.shawnclake.morgencore.core.component.property.Properties;

abstract public class ObserverWithSubject implements Observer {

    protected Subject subject;

    public abstract void update(Properties properties);

    public Subject getSubject() {
        return subject;
    }

}
