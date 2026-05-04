package com.dm.net.vzukh.messages.payload.image;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DefaultImage extends Image {
    @JsonCreator
    public DefaultImage(@JsonProperty("type") String type) {
        super(type);
    }
}
