package com.example.decorator;

//This is the core logging interface
//Any logger or decorator implements this

public interface ILogger {
    String log(LogLevel level, String message);
}

