package com.dm.net.vzukh.messages;

import java.time.Instant;

import com.dm.net.vzukh.messages.channel.Channel;
import com.dm.net.vzukh.messages.payload.Prompt;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PromptMessage<I extends Channel<?,?>> extends Message<I, Prompt> {

    @JsonCreator
    public PromptMessage(@JsonProperty("id") String id,
                         @JsonProperty("messageTs") Instant messageTs,
                         @JsonProperty("channel") I channel,
                         @JsonProperty("data") Prompt data) {
        super(id, MessageType.PROMPT, messageTs, channel, data);
    }
}
