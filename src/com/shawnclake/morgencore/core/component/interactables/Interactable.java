package com.shawnclake.morgencore.core.component.interactables;

import com.shawnclake.morgencore.core.component.events.EventsService;
import com.shawnclake.morgencore.core.component.messages.Message;
import com.shawnclake.morgencore.core.component.messages.StringMessage;
import com.shawnclake.morgencore.core.component.objects.dynamic.primitives.LazyDynamicPrimitive;
import com.shawnclake.morgencore.core.component.patterns.observer.Subject;
import com.shawnclake.morgencore.core.component.property.Properties;
import com.shawnclake.morgencore.core.component.services.Services;

public abstract class Interactable extends Subject {

    public String getTypeName()
    {
        return this.getClass().getName();
    }
    abstract public String getName();
    abstract public void output(Message message);
    public Message input(String message)
    {
        Message message1 = new StringMessage(this, message);
        this.doNotify(new Properties("message", new LazyDynamicPrimitive<>(message1)));
        Services.getService(EventsService.class).trigger(new InteractableInputEvent(message1));
        return message1;
    }

    @Override
    public String __str__() {
        return getName() + ": " + getTypeName();
    }
}
