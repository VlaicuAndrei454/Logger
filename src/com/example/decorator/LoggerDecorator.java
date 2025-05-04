package com.example.decorator;

public abstract class LoggerDecorator implements ILogger {
    protected final ILogger wrappee;

    public LoggerDecorator(ILogger wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void log(LogLevel level, String message) {
        wrappee.log(level, message);
    }
}

