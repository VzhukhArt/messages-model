package com.dm.net.vzukh.messages.utils;

import java.time.Instant;
import java.util.UUID;

import com.dm.net.vzukh.messages.EventMessage;
import com.dm.net.vzukh.messages.Message;
import com.dm.net.vzukh.messages.channel.Channel;
import com.dm.net.vzukh.messages.payload.events.Accepted;
import com.dm.net.vzukh.messages.payload.events.Finished;
import com.dm.net.vzukh.messages.payload.events.Processing;
import com.dm.net.vzukh.messages.payload.events.Start;

public final class MessageUtils {

    public static <I extends Channel<?,?>, C> EventMessage<I> accepted(Message<I, C> message) {
        return new EventMessage<>(UUID.randomUUID().toString(), Instant.now(), message.getChannel(), new Accepted());
    }


    public static <I extends Channel<?,?>> EventMessage<I> accepted(I channel) {
        return new EventMessage<>(UUID.randomUUID().toString(), Instant.now(), channel, new Accepted());
    }

    public static <I extends Channel<?,?>> EventMessage<I> start(I channel) {
        return new EventMessage<>(UUID.randomUUID().toString(), Instant.now(), channel, new Start());
    }


    public static <I extends Channel<?,?>> EventMessage<I> finished(I channel) {
        return new EventMessage<>(UUID.randomUUID().toString(), Instant.now(), channel, new Finished());
    }

    public static <I extends Channel<?,?>> EventMessage<I> processing(I channel) {
        return new EventMessage<>(UUID.randomUUID().toString(), Instant.now(), channel, new Processing());
    }


    private MessageUtils() {

    }
}
