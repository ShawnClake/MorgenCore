package com.shawnclake.morgencore.core.component.interactables;

import com.shawnclake.morgencore.core.component.services.Services;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InteractableServiceTest {

    @Test
    void getStateStatistics() {
        InteractableService interactableService = new InteractableService();
        interactableService.add(new TestInteractable());
        interactableService.add(new TestDiscordInteractable());
        System.out.println(Services.instance().__str__());
    }
}