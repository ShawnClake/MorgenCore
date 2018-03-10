package com.shawnclake.morgencore.core.component.messages;

import java.util.ArrayList;
import java.util.Date;

/**
 * ListMessage
 * A message wrapper which allows for a list of strings to be sent
 * Use Cases:
 *  - A multiline message
 *  - A wordwrapped message
 */
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
