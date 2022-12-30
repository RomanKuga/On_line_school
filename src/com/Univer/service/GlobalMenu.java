package com.Univer.service;

import com.Univer.models.Course;
import com.Univer.models.Lecture;
import com.Univer.repository.DataLecture;
import com.Univer.repository.DataMaster;

import java.util.Scanner;

import static com.Univer.service.ExitProgram.exitProgram;

public class GlobalMenu {
private DataLecture dataMaster;
public void globalMenu(DataLecture dataMaster) {
    this.dataMaster=dataMaster;
    Scanner scanner = new Scanner(System.in);
    boolean exitBoolean = false;
    while (!exitBoolean) {

        System.out.println("Виберіть номер категорії з якою будете працювати:");
        System.out.println("1. Курс");
        System.out.println("2. Вчителі");
        System.out.println("3. Студенти");
        System.out.println("4. Лекції");
        System.out.println("5. Вихід");

        int number = scanner.nextInt();

        switch (number) {
            case 1 -> {
                System.out.println("Ви вибрали категорію : Курс");
                exitBoolean = exitProgram();
            }
            case 2 -> {
                System.out.println("Ви вибрали категорію : Вчителі");
                exitBoolean = exitProgram();
            }
            case 3 -> {
                System.out.println("Ви вибрали категорію : Студенти");
                exitBoolean = exitProgram();
            }
            case 4 -> {
                System.out.println("Ви вибрали категорію : Лекції");
                LecturesService serLecture = new LecturesService();
                serLecture.menuLecrute(dataMaster);
            }
            case 5 -> {
                System.out.println("Дякую");
                exitBoolean = true;
            }
            default -> System.out.println("Такої категорії не існує");
        }
    }
    scanner.close();
  }
}

