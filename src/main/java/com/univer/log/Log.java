package com.univer.log;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Log {
    private String name;
    private String logLevel;
    private String massage;
    private LocalDateTime localDate;
    private StackTraceElement[] stackTrace;

    protected Log(String name, String logLevel, String massage, LocalDateTime localDate, StackTraceElement[] stackTrace) {
        this.name = name;
        this.logLevel = logLevel;
        this.massage = massage;
        this.localDate = localDate;
        this.stackTrace = stackTrace;
    }

    protected Log(String name, String logLevel, String massage, LocalDateTime localDate) {
        this.name = name;
        this.logLevel = logLevel;
        this.massage = massage;
        this.localDate = localDate;

    }

    @Override
    public String toString() {
        return " "+name+"  "+logLevel+"  "+massage+ "  " +localDate+"   "+ Arrays.toString(stackTrace) +"\n";
    }
}
