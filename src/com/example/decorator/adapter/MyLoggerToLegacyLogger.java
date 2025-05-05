package com.example.decorator.adapter;

import com.example.decorator.ILogger;

public class MyLoggerToLegacyLogger implements ILegacyLogger {
    ILogger reference;
    boolean loggerState = false;

    public MyLoggerToLegacyLogger(ILogger refference){
        this.reference = refference;
    }


    @Override
    public void logTheError(String[] log) {
        if(!loggerState){
            System.out.println("Logger is turned off");
        }else if(isItTooBig(computeTheLogSize(log))){
            System.out.println("Message too big!");
        }else{
            String message = String.join(" ", log);
            System.out.println(message);
        }
    }

    @Override
    public void setTheLoggingState(boolean state) {
        if(state) {
            System.out.println("*Logger ON*");
        }else
            System.out.println("*Logger OFF*");
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
