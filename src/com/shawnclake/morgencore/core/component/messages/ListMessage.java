package com.shawnclake.morgencore.core.component.messages;

import com.shawnclake.morgencore.core.component.interactables.Interactable;

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
    private Interactable sender;

    public ListMessage(ArrayList<String> message) {
        this.message = message;
        this.created_at = new Date();
    }

    public ListMessage(Interactable sender, ArrayList<String> message) {
        this.sender = sender;
        this.message = message;
        this.created_at = new Date();
    }

    public ListMessage(Interactable sender, ArrayList<String> message, Date created_at) {
        this.sender = sender;
        this.message = message;
        this.created_at = created_at;
    }

    public ArrayList<String> getMessage() {
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
