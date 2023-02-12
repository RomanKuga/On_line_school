package com.univer.service;

import com.univer.errorMenuService.ErrorTestNumber;
import com.univer.log.LogLevel;
import com.univer.log.LogWriter;

import java.io.IOException;

public class AdjustmentLogFile {
    public void AdjustmentLogFile() throws IOException {
        int df = 1;
        while (df == 1) {
            System.out.println("""
                    Виберіть LEVEL для запису логів у файл:
                     DEBUG  - 1
                     INFO   - 2
                     WARNING- 3
                     ERROR  - 4""");
            ErrorTestNumber number = new ErrorTestNumber();
            switch (number.testInt()) {
                case 1 -> {
                    System.out.println("Рівень логування:  DEBUG < INFO < WARNING < ERROR");
                    LogWriter.writeAdjustmentFile(LogLevel.DEBUG.name());
                    df=2;
                }
                case 2 -> {
                    System.out.println("Рівень логування:   INFO < WARNING < ERROR");
                    LogWriter.writeAdjustmentFile(LogLevel.INFO.name());
                    df=2;
                }
                case 3 -> {
                    System.out.println("Рівень логування:   WARNING < ERROR");
                    LogWriter.writeAdjustmentFile(LogLevel.WARNING.name());
                    df=2;
                }
                case 4 -> {
                    System.out.println("Рівень логування:   ERROR");
                    LogWriter.writeAdjustmentFile(LogLevel.ERROR.name());
                    df=2;
                }

                default -> System.out.println("Такої категорії не існує");
            }
        }
    }
}
