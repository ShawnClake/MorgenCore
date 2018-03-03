package com.shawnclake.morgencore.core.component.db.interfaces;

import com.shawnclake.morgencore.core.component.db.Connection;

public interface DatabaseConnection {

    Connection getConnection();
    void setConnection(Connection connection);

}
