package com.example.decorator;


import com.example.decorator.adapter.ILegacyLogger;
import com.example.decorator.adapter.MyLoggerToLegacyLogger;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Base logger: only ERRORs (default threshold)
        ILogger baseLogger = new ConsoleLogger();

        // 1) Simple case: only ERRORs, no metadata
        System.out.println("=== Default (ERROR-only) ===");
        System.out.println(baseLogger.log(LogLevel.INFO,  "This INFO will NOT show"));
        System.out.println(baseLogger.log(LogLevel.ERROR, "This ERROR will show"));

        // 2) Add LEVEL and TIMESTAMP
        ILogger lvlTsLogger =
                new TimestampDecorator(new LevelDecorator(baseLogger));
        System.out.println("\n=== LEVEL + TIMESTAMP (still ERROR-only) ===");
        System.out.println(lvlTsLogger.log(LogLevel.INFO,  "This INFO will NOT show"));
        System.out.println(lvlTsLogger.log(LogLevel.ERROR, "This ERROR shows with [ERROR] and timestamp"));

        // 3) Full: threshold DEBUG + LEVEL + TIMESTAMP + THREAD ID
        ThreadIdDecorator fullLogger =
                new ThreadIdDecorator(
                        new TimestampDecorator(
                                new LevelDecorator(
                                        new ConsoleLogger(LogLevel.DEBUG)
                                )
                        )
                );
        System.out.println("\n=== DEBUG+LEVEL+TS+TID ===");
        System.out.println(fullLogger.log(LogLevel.DEBUG, "Now DEBUG also appears with all metadata!"));
        System.out.println(fullLogger.log(LogLevel.INFO,  "And INFO too"));
        String[] error = fullLogger.log(LogLevel.INFO,  "And INFO too").split(" ");
        String[] tooBig = {"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",
        "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc"};
        ILegacyLogger legacyLogger = new MyLoggerToLegacyLogger(fullLogger);

        System.out.println("\n=== ADAPTER ===");
        // 1) legacyLogger: turned off
        legacyLogger.logTheError(error);
        // 2) turning on the logger and printing the log
        legacyLogger.setTheLoggingState(true);
        legacyLogger.logTheError(error);
        // 3) message too big
        legacyLogger.logTheError(tooBig);
    }
}

