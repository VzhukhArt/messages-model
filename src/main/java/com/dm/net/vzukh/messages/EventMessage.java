package com.dm.net.vzukh.messages;

import java.time.Instant;

import com.dm.net.vzukh.messages.channel.Channel;
import com.dm.net.vzukh.messages.payload.events.Event;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EventMessage<I extends Channel<?,?>> extends Message<I, Event> {

    @JsonCreator
    public EventMessage(@JsonProperty("id") String id,
                        @JsonProperty("messageTs") Instant messageTs,
                        @JsonProperty("channel") I channel,
                        @JsonProperty("data") Event data) {
        super(id, MessageType.EVENT, messageTs, channel, data);
    }
}
