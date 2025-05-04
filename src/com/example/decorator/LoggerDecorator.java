package com.example.decorator;


//The base class for decorators
//Delegates all calls by default

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

