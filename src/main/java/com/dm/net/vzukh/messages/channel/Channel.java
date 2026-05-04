package com.dm.net.vzukh.messages.channel;

import com.dm.net.vzukh.messages.extensions.AbstractExtensibleContainer;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        defaultImpl = DefaultChannel.class,
        visible = true
)
public abstract class Channel<C,R> extends AbstractExtensibleContainer {
    private final String type;
    private final String subType;
    private final C id;
    private final R correlationId;

    public Channel(String type, String subType, C id, R correlationId) {
        this.type = type;
        this.subType = subType;
        this.id = id;
        this.correlationId = correlationId;
    }

    public C getId(){
        return id;
    }

    public String getType() {
        return type;
    }

    public String getSubType() {
        return subType;
    }

    public R getCorrelationId() {
        return correlationId;
    }
}

