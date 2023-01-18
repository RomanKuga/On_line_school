package com.univer.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ErrorService {

    public int testInt(){
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int r = 1;
        while (r != 2) {
            try {
                number = scanner.nextInt();
                r = 2;
            } catch (InputMismatchException ex) {
                System.out.println("Ви набрали символ замість числа, спробуйте знову!");
                String stop=scanner.next();
            }
        }
        return number;
    }
}
