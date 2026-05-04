package com.dm.net.vzukh.messages.payload.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UnknownEvent extends Event{
    @JsonCreator
    public UnknownEvent(
            @JsonProperty("type") String type) {
        super(type);
    }
}
