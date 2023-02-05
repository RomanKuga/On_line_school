package com.univer.errorMenuService;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.log.LogWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorTestNumber {

    public int testInt() throws IOException {
        Scanner scanner = new Scanner(System.in);
     LogCreateObject.logInfo(this.getClass().getName(), LogLevel.DEBUG.name(), "Перевірка числа на вміст символа ", LocalDateTime.now());

        int number = 0;
        int r = 1;
        while (r != 2) {
            try {
                number = scanner.nextInt();

                r = 2;
            } catch (InputMismatchException ex) {
                LogCreateObject.error(LogWriter.class.getName(),LogLevel.ERROR.name(),
                        "Error during io example", LocalDateTime.now(),
                        ex.getStackTrace());
                System.out.println("Ви набрали символ замість числа, спробуйте знову!");
                String stop=scanner.next();
            }
        }
        return number;
    }
}
