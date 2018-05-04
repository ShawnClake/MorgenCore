package com.shawnclake.morgencore.core.component;

import java.util.UUID;

public class Unique {

    private UUID uuid;

    public Unique(UUID uuid) {
        this.uuid = uuid;
    }

    public Unique() {
        uuid = UUID.randomUUID();
    }

}
