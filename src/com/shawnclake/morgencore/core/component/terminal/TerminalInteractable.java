package com.shawnclake.morgencore.core.component.terminal;

import com.shawnclake.morgencore.core.component.interactables.Interactable;
import com.shawnclake.morgencore.core.component.messages.Message;

public class TerminalInteractable extends Interactable {

    @Override
    public String getName() {
        return "Terminal Interactable";
    }

    @Override
    public void output(Message message) {
        Output.pln(message.get());
    }

}
