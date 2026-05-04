package com.dm.net.vzukh.messages.extensions;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;


public abstract class AbstractExtensibleContainer {

    @JsonIgnore
    private final Map<String,Object> extensions = new HashMap<>();

    @JsonAnyGetter
    public Map<String,Object> getExtensions() {
        return this.extensions;
    }

    @JsonAnySetter
    public void setExtension(String name, Object value) {
        this.extensions.put(name, value);
    }

}
