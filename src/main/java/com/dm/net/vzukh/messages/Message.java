package com.dm.net.vzukh.messages;

import java.time.Instant;

import com.dm.net.vzukh.messages.channel.Channel;
import com.dm.net.vzukh.messages.extensions.AbstractExtensibleContainer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        defaultImpl = UnknownMessage.class
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PromptMessage.class, name = "PROMPT"),
        @JsonSubTypes.Type(value = ImageMessage.class, name = "IMAGE"),
        @JsonSubTypes.Type(value = EventMessage.class, name = "EVENT")
        })
public abstract class Message<I extends Channel<?,?>, C> extends AbstractExtensibleContainer {

    private final String id;
    private final MessageType type;
    private final Instant messageTs;
    private final I channel;
    private final C data;

    @JsonCreator
    public Message(@JsonProperty("id") String id,
                   @JsonProperty("type") MessageType type,
                   @JsonProperty("messageTs") Instant messageTs,
                   @JsonProperty("channel") I channel,
                   @JsonProperty("data") C data) {
        this.id = id;
        this.type = type;
        this.messageTs = messageTs;
        this.channel = channel;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public Instant getMessageTs() {
        return messageTs;
    }

    public I getChannel() {
        return channel;
    }

    public C getData() {
        return data;
    }

    public MessageType getType() {
        return type;
    }
}
