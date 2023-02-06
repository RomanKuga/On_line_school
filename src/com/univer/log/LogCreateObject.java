package com.univer.log;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogCreateObject {
    private static List<Log> logsStorage = new ArrayList<>();

    public static Log error(String name, String logLevel, String massage, LocalDateTime localDateTime,StackTraceElement[] stackTrace) throws IOException {
        Log errorLog = new Log(name, logLevel, massage,localDateTime, stackTrace);
        logsStorage.add(errorLog);
        LogWriter.writeDataToFile(errorLog);
        return errorLog;
    }

    public static Log warning(String name, String logLevel, String massage, LocalDateTime localDateTime,StackTraceElement[] stackTrace) throws IOException {
        Log errorLog = new Log(name, logLevel, massage,localDateTime, stackTrace);
        logsStorage.add(errorLog);
        LogWriter.writeDataToFile(errorLog);
        return errorLog;
    }

    public static Log logInfo(String name, String logLevel, String massage, LocalDateTime localDateTime) throws IOException {
        Log infoLog = new Log(name, logLevel, massage, localDateTime);
        logsStorage.add(infoLog);
        LogWriter.writeDataToFile(infoLog);
        return infoLog;
    }
    public static Log logDebug(String name, String logLevel, String massage, LocalDateTime localDateTime) throws IOException {
        Log infoLog = new Log(name, logLevel, massage, localDateTime);
        logsStorage.add(infoLog);
        LogWriter.writeDataToFile(infoLog);
        return infoLog;
    }

    public static List<Log> getLogsStorage() {
        return logsStorage;
    }
}
