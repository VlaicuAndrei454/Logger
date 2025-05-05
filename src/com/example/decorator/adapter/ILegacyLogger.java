package com.example.adapter.abstracts;

public interface ILegacyLogger {

    void logTheError(String[] log); // used for actually logging the error
    void setTheLoggingState(boolean state); // used for enabling/disabling the logger
    int computeTheLogSize(String[] log); // compute the size in bytes of the log message
    int MAX_LOG_SIZE = 100;
    boolean isItTooBig(int logSize); // is the log too big to be written?
}
