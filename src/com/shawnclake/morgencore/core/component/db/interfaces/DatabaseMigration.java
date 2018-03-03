package com.shawnclake.morgencore.core.component.db.interfaces;

import com.shawnclake.morgencore.core.component.db.Connection;

public interface DatabaseMigration {

    boolean up(Connection connection);
    boolean down(Connection connection);
    int getVersion();

}
