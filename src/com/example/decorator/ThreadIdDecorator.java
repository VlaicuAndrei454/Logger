package com.example.decorator;

//adds the current thread’s ID in “[TID:id] ” form.

public class ThreadIdDecorator extends LoggerDecorator {
    public ThreadIdDecorator(ILogger wrappee) {
        super(wrappee);
    }

    @Override
    public String log(LogLevel level, String message) {
        String withThread = "[TID:" + Thread.currentThread().getId() + "] " + message;
        return super.log(level, withThread);
    }
}

