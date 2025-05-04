package com.example.decorator;

public class LevelDecorator extends LoggerDecorator {
    public LevelDecorator(ILogger wrappee) {
        super(wrappee);
    }

    @Override
    public void log(LogLevel level, String message) {
        String withLevel = "[" + level + "] " + message;
        super.log(level, withLevel);
    }
}

