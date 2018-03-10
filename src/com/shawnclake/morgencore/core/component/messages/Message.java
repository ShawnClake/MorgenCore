package com.shawnclake.morgencore.core.component.messages;

import java.util.Date;

/**
 * Message
 * Messages are an abstract way of facilitating text flow between entities within an application
 * Example use cases:
 *  - Chat
 *  - Packets
 *  - Messages between modules of an application
 *  - Comments
 *  - A wrapper between a database model and business logic
 */
public interface Message {
    Date getCreated_at();
}
