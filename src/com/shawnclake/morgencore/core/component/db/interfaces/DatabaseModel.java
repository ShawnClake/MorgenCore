package com.shawnclake.morgencore.core.component.db.interfaces;

import java.util.HashMap;

public interface DatabaseModel {

    HashMap<Integer, DatabaseMigration> getMigrations();
    String getTableName();
    int getVersion();


}
