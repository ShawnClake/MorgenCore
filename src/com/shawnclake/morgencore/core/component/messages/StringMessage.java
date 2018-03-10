package com.shawnclake.morgencore.core.component.messages;

import java.util.Date;

/**
 * StringMessage
 * Simplistic message interface of a single string
 */
public class StringMessage implements Message {

    private String message;
    private Date created_at;

    public StringMessage(String message) {
        this.message = message;
        this.created_at = new Date();
    }

    public StringMessage(String message, Date created_at) {
        this.message = message;
        this.created_at = created_at;
    }

    public String getMessage() {
        return message;
    }

    public Date getCreated_at() {
        return created_at;
    }

}
