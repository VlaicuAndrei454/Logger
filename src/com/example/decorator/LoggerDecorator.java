package com.example.decorator;


//The base class for decorators
//Delegates all calls by default

public abstract class LoggerDecorator implements ILogger {
    protected final ILogger wrappee;

    public LoggerDecorator(ILogger wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public String log(LogLevel level, String message) {
        return wrappee.log(level, message);
    }
}

