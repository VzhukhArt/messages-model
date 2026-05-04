package com.dm.net.vzukh.messages.payload.image;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class S3Image extends Image {
    private final String s3key;

    @JsonCreator
    public S3Image(@JsonProperty("s3key") String s3key) {
        super(ImageTypes.S3_TYPE);
        this.s3key = s3key;
    }

    public String getS3key() {
        return s3key;
    }
}
