package com.univer.service;

import com.univer.controlWork.ControlWork;
import com.univer.errorMenuService.ValidationUtil;
import com.univer.homeWork27.HomeWorK27;
import com.univer.homeWork28.HomeWork28;
import com.univer.homeWork29.HomeWork29;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.repository.*;
import com.univer.serverANDclient.MenuServAndClient;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.concurrent.TimeUnit.SECONDS;
//@Component
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
            System.out.println("7. Редагувати BlackList адрес");
            System.out.println("8. Дмашня робота 27");
            System.out.println("9. Дмашня робота 28");
            System.out.println("10. Дмашня робота 29");
            System.out.println("11. Вихід");
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
                    new ControlWork().randomStudent(dataPerson);
                    ExecutorService executorService = Executors.newFixedThreadPool(10);

                    for (int i = 0; i < 10; i++) {
                        executorService.execute(new ControlWork(i));
                    }

                    if (executorService.awaitTermination(12, SECONDS)){

                    executorService.shutdownNow();
                    System.out.println(executorService);}
                }
                case 6 ->  new AdjustmentLogFile().menuAdjustmentLogFile();

                case 7 -> {
                    MenuServAndClient menuBlackLis=  new MenuServAndClient();
                    menuBlackLis.menuBlackList();
                }
                case 8 -> {
                    new HomeWorK27().homeWork27Task2();
                    new HomeWorK27().homeWork27Task3();
                }
                case 9 -> {
                    new HomeWork28().logFileMessageInfo();
                    new HomeWork28().minDateMaxAddMaterialLecture();
                }
                case 10 -> {
                    new HomeWork29().lectureGroupOfTeacher();
                    new HomeWork29().lectureGroupOfAddMaterial();
                    new HomeWork29().mailNameSecondNameMap();
                    new HomeWork29().mailStudentToFile();
                }
                case 11 -> {
                    exitBoolean = ExitProgram.exitProgram();
                    System.out.println("Дякую");
                }
                default -> System.out.println("Такої категорії не існує");
            }
        }
        scanner.close();
    }

}

