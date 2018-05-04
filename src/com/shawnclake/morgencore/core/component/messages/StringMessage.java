package com.shawnclake.morgencore.core.component.messages;

import com.shawnclake.morgencore.core.component.interactables.Interactable;

import java.util.Date;

/**
 * StringMessage
 * Simplistic message interface of a single string
 */
public class StringMessage implements Message {

    private String message;
    private Date created_at;
    private Interactable sender;

    public StringMessage(String message) {
        this.message = message;
        this.created_at = new Date();
    }

    public StringMessage(Interactable sender, String message) {
        this.sender = sender;
        this.message = message;
        this.created_at = new Date();
    }

    public StringMessage(Interactable sender, String message, Date created_at) {
        this.sender = sender;
        this.message = message;
        this.created_at = created_at;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreated_at() {
        return created_at;
    }

    @Override
    public Interactable getSender() {
        return sender;
    }

}
