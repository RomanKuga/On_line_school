package com.univer.service;

import java.util.Scanner;

public class ExitProgram {
    public static boolean exitProgram(){
        boolean exitVers = false;
        Scanner nextScanner = new Scanner(System.in);
        System.out.println("Бажаєте вийти з програми");
        System.out.println("1. Так");
        System.out.println("2. Ні");
        int nextY=nextScanner.nextInt();
        if (nextY==1){
            exitVers =true;
          }
        return exitVers;
    }
}
