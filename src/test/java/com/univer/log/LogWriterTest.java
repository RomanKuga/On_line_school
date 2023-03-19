package com.univer.log;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogWriterTest {
    @Test
    void testLoadLogWriterFromValidFile() throws IOException {
        LogWriter.writeAdjustmentFile(LogLevel.INFO.name());
        Log log = LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до загального меню програми ", LocalDateTime.now());
        String logString = String.valueOf(log);
        LogWriter.writeDataToFile(log, LogLevel.INFO.name());
        var logList = Files.newBufferedReader(Path.of("src/main/java/com/univer/Log_Info.txt"));
        assertTrue(logList.lines().anyMatch(str -> str.trim().contains(logString.trim())));
        logList.close();

    }

    @Test
    void testLoadLogWriterFromValidFileLogLevel() throws IOException {
        LogWriter.writeAdjustmentFile(LogLevel.WARNING.name());
        Log logInfo = new Log(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до загального меню програми ", LocalDateTime.now());
        String logStringInfo = String.valueOf(logInfo);
        LogWriter.writeDataToFile(logInfo, LogLevel.INFO.name());
        Log logError = new Log(this.getClass().getName(), LogLevel.ERROR.name(), "Перехід до загального меню програми ", LocalDateTime.now());
        String logStringError = String.valueOf(logError);
        LogWriter.writeDataToFile(logError, LogLevel.ERROR.name());


        var logList = Files.newBufferedReader(Path.of("src/main/java/com/univer/Log_Info.txt"));
        assertFalse(logList.lines().anyMatch(str -> str.trim().contains(logStringInfo.trim())));
        logList.close();
        var logListnew = Files.newBufferedReader(Path.of("src/main/java/com/univer/Log_Info.txt"));
        assertTrue(logListnew.lines().anyMatch(str -> str.trim().contains(logStringError.trim())));
        logListnew.close();
    }

}
