package com.dm.net.vzukh.messages.payload.events;


import com.dm.net.vzukh.messages.EventMessage;
import com.dm.net.vzukh.messages.ImageMessage;
import com.dm.net.vzukh.messages.PromptMessage;
import com.dm.net.vzukh.messages.UnknownMessage;
import com.dm.net.vzukh.messages.extensions.AbstractExtensibleContainer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        defaultImpl = UnknownEvent.class,
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Accepted.class, name = EventTypes.ACCEPTED),
        @JsonSubTypes.Type(value = Start.class, name = EventTypes.START),
        @JsonSubTypes.Type(value = Processing.class, name = EventTypes.PROCESSING),
        @JsonSubTypes.Type(value = Finished.class, name = EventTypes.FINISHED),
})
public abstract class Event extends AbstractExtensibleContainer {

    private final String type;

    protected Event(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
