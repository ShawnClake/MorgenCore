package com.shawnclake.morgencore.core.component.messages;

import java.util.Date;

public class Message {

    private String message;
    private Date created_at;

    public Message(String message) {
        this.message = message;
        this.created_at = new Date();
    }

    public Message(String message, Date created_at) {
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
