package com.example.decorator;


public class Main {
    public static void main(String[] args) {
        // Base logger: only ERRORs (default threshold)
        ILogger baseLogger = new ConsoleLogger();

        // 1) Simple case: only ERRORs, no metadata
        System.out.println("=== Default (ERROR-only) ===");
        baseLogger.log(LogLevel.INFO,  "This INFO will NOT show");
        baseLogger.log(LogLevel.ERROR, "This ERROR will show");

        // 2) Add LEVEL and TIMESTAMP
        ILogger lvlTsLogger =
                new TimestampDecorator(new LevelDecorator(baseLogger));
        System.out.println("\n=== LEVEL + TIMESTAMP (still ERROR-only) ===");
        lvlTsLogger.log(LogLevel.INFO,  "This INFO will NOT show");
        lvlTsLogger.log(LogLevel.ERROR, "This ERROR shows with [ERROR] and timestamp");

        // 3) Full: threshold DEBUG + LEVEL + TIMESTAMP + THREAD ID
        ILogger fullLogger =
                new ThreadIdDecorator(
                        new TimestampDecorator(
                                new LevelDecorator(
                                        new ConsoleLogger(LogLevel.DEBUG)
                                )
                        )
                );
        System.out.println("\n=== DEBUG+LEVEL+TS+TID ===");
        fullLogger.log(LogLevel.DEBUG, "Now DEBUG also appears with all metadata!");
        fullLogger.log(LogLevel.INFO,  "And INFO too");
    }
}

