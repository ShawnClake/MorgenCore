package com.shawnclake.morgencore.core.component.messages;

import java.util.ArrayList;
import java.util.Date;

public class ListMessage implements Message {

    private ArrayList<String> message;
    private Date created_at;

    public ListMessage(ArrayList<String> message) {
        this.message = message;
        this.created_at = new Date();
    }

    public ListMessage(ArrayList<String> message, Date created_at) {
        this.message = message;
        this.created_at = created_at;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public Date getCreated_at() {
        return created_at;
    }

}
