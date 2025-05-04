package com.example.decorator;


public class ThreadIdDecorator extends LoggerDecorator {
    public ThreadIdDecorator(ILogger wrappee) {
        super(wrappee);
    }

    @Override
    public void log(LogLevel level, String message) {
        String withThread = "[TID:" + Thread.currentThread().getId() + "] " + message;
        super.log(level, withThread);
    }
}

