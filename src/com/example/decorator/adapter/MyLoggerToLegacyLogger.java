package com.example.adapter;

import com.example.adapter.abstracts.ILegacyLogger;
import com.example.adapter.abstracts.AMyLogger;
import com.example.adapter.abstracts.LogLevel;

public class MyLoggerToLegacyLogger implements ILegacyLogger {
    AMyLogger refference;

    public MyLoggerToLegacyLogger(AMyLogger refference){
        this.refference = refference;
    }

    boolean loggerState;

    @Override
    public void logTheError(String[] log) {
        LogLevel level = LogLevel.valueOf(log[0]);
        refference.log(level, log[1]);
    }

    @Override
    public void setTheLoggingState(boolean state) {
        this.loggerState = state;
    }

    @Override
    public int computeTheLogSize(String[] log) {
        int sum = 0;
        for(String s : log)
            for (byte b : s.getBytes()) {
                sum+= (int) b;
            }
        return sum;
    }

    @Override
    public boolean isItTooBig(int logSize) {
        if (logSize > 16_384)
            return true;
        return false;

    }
}
