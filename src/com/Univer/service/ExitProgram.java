package com.Univer.service;

import java.util.Scanner;

public class ExitProgram {
    public static boolean exitProgram(){
        boolean exitVers = false;
        Scanner nextScanner = new Scanner(System.in);
        System.out.println("Бажаєте вийти з програми");
        System.out.println("1. Так");
        System.out.println("2. Ні");
        int nextY=nextScanner.nextInt();
        switch (nextY){
            case 1:
                exitVers =true;
                break;
            case 2:
                exitVers =false;
                break;
            default:
                System.out.println("Ви не вибрали");
        }
        return exitVers;
    }
}
