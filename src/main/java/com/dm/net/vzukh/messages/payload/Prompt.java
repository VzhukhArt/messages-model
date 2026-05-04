package com.dm.net.vzukh.messages.payload;

import com.dm.net.vzukh.messages.extensions.AbstractExtensibleContainer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Prompt extends AbstractExtensibleContainer {
    private final String text;

    @JsonCreator
    public Prompt(@JsonProperty("text") String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
