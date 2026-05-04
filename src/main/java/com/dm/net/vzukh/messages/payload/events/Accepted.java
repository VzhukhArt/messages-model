package com.dm.net.vzukh.messages.payload.events;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Accepted extends Event {
    @JsonCreator
    public Accepted() {
        super(EventTypes.ACCEPTED);
    }
}
