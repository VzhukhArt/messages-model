package com.dm.net.vzukh.messages;

import java.time.Instant;

import com.dm.net.vzukh.messages.channel.Channel;
import com.dm.net.vzukh.messages.payload.image.Image;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageMessage<I extends Channel<?,?>> extends Message<I, Image> {

    @JsonCreator
    public ImageMessage(@JsonProperty("id") String id,
                        @JsonProperty("messageTs") Instant messageTs,
                        @JsonProperty("channel") I channel,
                        @JsonProperty("data") Image data) {
        super(id, MessageType.IMAGE, messageTs, channel, data);
    }
}
