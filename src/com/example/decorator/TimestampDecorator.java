package com.example.decorator;

import java.time.Instant;

//Adds an ISO‐style timestamp to each message.

public class TimestampDecorator extends LoggerDecorator {
    public TimestampDecorator(ILogger wrappee) {
        super(wrappee);
    }

    @Override
    public String log(LogLevel level, String message) {
        String withTs = Instant.now() + " " + message;
        return super.log(level, withTs);
    }
}

