package com.dm.net.vzukh.messages.channel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultChannel extends Channel<Object,Object> {

    @JsonCreator
    public DefaultChannel(@JsonProperty("type") String type,
                          @JsonProperty("subtype") String subType,
                          @JsonProperty("id") Object id,
                          @JsonProperty("correlationId") Object correlationId) {
        super(type, subType, id, correlationId);
    }
}
