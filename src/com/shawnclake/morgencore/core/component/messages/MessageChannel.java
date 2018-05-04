package com.shawnclake.morgencore.core.component.messages;

import com.shawnclake.morgencore.core.component.Unique;
import com.shawnclake.morgencore.core.component.patterns.observer.Subject;

import java.util.ArrayList;

public class MessageChannel extends Subject {

    private Unique uuid;
    private String name;
    private ArrayList<Message> messages;

    public MessageChannel() {
        uuid = new Unique();
    }

    public MessageChannel(Unique uuid) {
        this.uuid = uuid;
    }

    public MessageChannel setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public Unique getUuid() {
        return uuid;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public void sendMessage(Message message)
    {
        messages.add(message);
        this.doNotify();
    }



}
