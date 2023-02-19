package com.univer.service;

import com.univer.controlWork.ControlWork;
import com.univer.errorMenuService.ValidationUtil;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.repository.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;

public class GlobalMenu {


    public void globalMenu(RepositoryLecture repositoryLecture, RepositoryPerson dataPerson, RepositoryHomeWork homeWork, RepositoryAddMaterial addMaterial, RepositoryCourse dataCourse) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean exitBoolean = false;
        while (!exitBoolean) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до загального меню програми ", LocalDateTime.now());

            System.out.println("Виберіть номер категорії з якою будете працювати:");
            System.out.println("1. Курс");
            System.out.println("2. Персони");
            System.out.println("3. Лекції");
            System.out.println("4. Додаткові матеріали");
            System.out.println("5. Контрольна робота");
            System.out.println("6. Виберіть LEVEL для запису логів у файл");
            System.out.println("7. Вихід");
            ValidationUtil number = new ValidationUtil();

            switch (number.testInt()) {
                case 1 -> {
                    System.out.println("Ви вибрали категорію : Курс");
                    CourseService serCourse=new CourseService();
                    serCourse.menuCourse(dataCourse);
                }
                case 2 -> {
                    System.out.println("Ви вибрали категорію : Вчителі та Студенти");
                    PersonService serPerson = new PersonService();
                    serPerson.menuPerson(dataPerson);
                }
                case 3 -> {
                    System.out.println("Ви вибрали категорію : Лекції");
                    LecturesService serLecture = new LecturesService();
                    serLecture.menuLecrute(repositoryLecture, dataPerson, homeWork,addMaterial);
                }
                case 4 -> {
                    System.out.println("Ви вибрали категорію : Додаткові матеріали");
                    AddMaterialService serAddMaterial = new AddMaterialService();
                    serAddMaterial.menuAddMaterials(addMaterial);
                }
                case 5 -> {
                    new ControlWork().rundomStudent(dataPerson);
                    ExecutorService executorService = Executors.newFixedThreadPool(10);

                    for (int i = 0; i < 10; i++) {
                        executorService.execute(new ControlWork(i));
                    }

                    executorService.awaitTermination(12, SECONDS);

                    executorService.shutdownNow();
                    System.out.println(executorService);
                }
                case 6 -> {
                    AdjustmentLogFile menuALF= new AdjustmentLogFile();
                    menuALF.AdjustmentLogFile();
                }
                case 7 -> {
                    exitBoolean = ExitProgram.exitProgram();
                    System.out.println("Дякую");
                }
                default -> System.out.println("Такої категорії не існує");
            }
        }
        scanner.close();
    }

}

