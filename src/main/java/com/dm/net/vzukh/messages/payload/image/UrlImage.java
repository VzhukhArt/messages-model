package com.dm.net.vzukh.messages.payload.image;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlImage extends Image {

    private final String url;

    @JsonCreator
    public UrlImage(@JsonProperty("url") String url) {
        super(ImageTypes.URL_TYPE);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
