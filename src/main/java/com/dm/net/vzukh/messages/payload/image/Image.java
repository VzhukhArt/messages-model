package com.dm.net.vzukh.messages.payload.image;

import com.dm.net.vzukh.messages.extensions.AbstractExtensibleContainer;
import com.dm.net.vzukh.messages.payload.events.UnknownEvent;
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
        @JsonSubTypes.Type(value = S3Image.class, name= ImageTypes.S3_TYPE),
        @JsonSubTypes.Type(value = UrlImage.class, name= ImageTypes.URL_TYPE),
})
public class Image extends AbstractExtensibleContainer {
    private final String type;

    public Image(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
