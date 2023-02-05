package com.univer.service;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ExitProgram {
    public static boolean exitProgram() throws IOException {
        LogCreateObject.logInfo(ExitProgram.class.getName(), LogLevel.INFO.name(), "Перехід меню завершення програми ", LocalDateTime.now());
        boolean exitVers = false;
        Scanner nextScanner = new Scanner(System.in);
        System.out.println("Бажаєте вийти з програми");
        System.out.println("1. Так");
        System.out.println("2. Ні");
        int nextY=nextScanner.nextInt();
        if (nextY==1){
            exitVers =true;
            System.out.println(LogCreateObject.getLogsStorage());
            LogCreateObject.logInfo(ExitProgram.class.getName(), LogLevel.INFO.name(), "Програма завершила роботу ", LocalDateTime.now());
          }
        return exitVers;
    }

    public void printArray(List<LogCreateObject> lect) {
        System.out.println(lect);
    }
}
