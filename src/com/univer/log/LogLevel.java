package com.univer.log;

public enum LogLevel {
    ERROR("ERROR"), WARNING("WARNING"), INFO("INFO"), DEBUG("DEBUG");
    private final String enumLevelLog;

    LogLevel(String enumLevelLog) {
        this.enumLevelLog = enumLevelLog;
    }
}
