package com.shawnclake.morgencore.core.component.interactables;

import com.shawnclake.morgencore.core.component.messages.StringMessage;
import com.shawnclake.morgencore.core.component.patterns.observer.Observer;
import com.shawnclake.morgencore.core.component.property.Properties;
import com.shawnclake.morgencore.core.component.terminal.Output;

public class InteractableObserver implements Observer {
    @Override
    public void update(Properties properties) {
        Output.pln("Observed: " + ((StringMessage)properties.get("message").getProperty(StringMessage.class)).get());
    }
}
