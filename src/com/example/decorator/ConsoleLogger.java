package com.example.decorator;


//Basic logger
//Only emits messages >= threshold(default = Error)
public class ConsoleLogger implements ILogger {
    private LogLevel threshold;

    public ConsoleLogger() {
        this.threshold = LogLevel.ERROR;  // default only ERROR
    }

    public ConsoleLogger(LogLevel threshold) {
        this.threshold = threshold;
    }

    @Override
    public void log(LogLevel level, String message) {
        if (level.ordinal() >= threshold.ordinal()) {
            System.out.println(message);
        }
    }
}

