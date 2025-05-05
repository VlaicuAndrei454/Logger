package com.example.decorator;


//Adds “[LEVEL] ” (e.g. “[INFO] ”) to each message.
public class LevelDecorator extends LoggerDecorator {
    public LevelDecorator(ILogger wrappee) {
        super(wrappee);
    }

    @Override
    public String log(LogLevel level, String message) {
        String withLevel = "[" + level + "] " + message;
        return super.log(level, withLevel);
    }
}

