package com.univer.service;

import com.univer.errorMenuService.ErrorTestNumber;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.repository.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class GlobalMenu {
    private RepositoryLecture repositoryLecture;
    private RepositoryPerson dataPerson;
    private RepositoryHomeWork homeWork;
    private RepositoryAddMaterial addMaterial;
    private RepositoryCourse dataCourse;

    public void globalMenu(RepositoryLecture repositoryLecture, RepositoryPerson dataPerson, RepositoryHomeWork homeWork, RepositoryAddMaterial addMaterial, RepositoryCourse dataCourse) throws IOException {
        this.repositoryLecture = repositoryLecture;
        this.dataPerson = dataPerson;
        this.homeWork = homeWork;
        this.addMaterial=addMaterial;
        this.dataCourse=dataCourse;
        Scanner scanner = new Scanner(System.in);
        boolean exitBoolean = false;
        while (!exitBoolean) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до загального меню програми ", LocalDateTime.now());

            System.out.println("Виберіть номер категорії з якою будете працювати:");
            System.out.println("1. Курс");
            System.out.println("2. Персони");
            System.out.println("3. Лекції");
            System.out.println("4. Додаткові матеріали");
            System.out.println("5. Вихід");
            ErrorTestNumber number = new ErrorTestNumber();

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
                    exitBoolean = ExitProgram.exitProgram();
                    System.out.println("Дякую");
                }
                default -> System.out.println("Такої категорії не існує");
            }
        }
        scanner.close();
    }

}

