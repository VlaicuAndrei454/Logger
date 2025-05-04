package com.example.decorator;

import java.time.Instant;

public class TimestampDecorator extends LoggerDecorator {
    public TimestampDecorator(ILogger wrappee) {
        super(wrappee);
    }

    @Override
    public void log(LogLevel level, String message) {
        String withTs = Instant.now() + " " + message;
        super.log(level, withTs);
    }
}

