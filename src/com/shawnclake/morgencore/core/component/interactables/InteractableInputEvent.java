package com.shawnclake.morgencore.core.component.interactables;

import com.shawnclake.morgencore.core.component.events.Event;
import com.shawnclake.morgencore.core.component.messages.Message;

public class InteractableInputEvent implements Event {

    private Message message;

    public InteractableInputEvent(Message message) {
        this.message = message;
    }

    public Message getMessage() {
        return message;
    }
}
