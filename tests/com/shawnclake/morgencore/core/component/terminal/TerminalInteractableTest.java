package com.shawnclake.morgencore.core.component.terminal;

import com.shawnclake.morgencore.core.component.commands.CommandEventListener;
import com.shawnclake.morgencore.core.component.events.EventsService;
import com.shawnclake.morgencore.core.component.interactables.InteractableObserver;
import com.shawnclake.morgencore.core.component.interactables.InteractableService;
import com.shawnclake.morgencore.core.component.messages.StringMessage;
import com.shawnclake.morgencore.core.component.services.Services;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminalInteractableTest {

    @Test
    void output() {
        new EventsService();
        Services.getService(EventsService.class).registerListener(new CommandEventListener());

        new InteractableService();

        TerminalInteractable terminalInteractable = new TerminalInteractable();
        terminalInteractable.addObserver(new InteractableObserver());
        Services.getService(InteractableService.class).add(terminalInteractable);

        terminalInteractable.output(new StringMessage("hi"));
        Services.getService(InteractableService.class).getItem(TerminalInteractable.class).output(new StringMessage("wtf"));

        Input.simulateInput("test");
        Input.readLine(terminalInteractable).get();

        Input.simulateInput("another test");
        Input.readLine(terminalInteractable).get();
    }
}