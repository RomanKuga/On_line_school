package com.univer.service;

import com.univer.repository.RepositoryLecture;
import com.univer.repository.RepositoryPerson;

import java.util.Scanner;

import static com.univer.service.ExitProgram.exitProgram;

public class GlobalMenu {
    private RepositoryLecture repositoryLecture;
    private RepositoryPerson dataPerson;

    public void globalMenu(RepositoryLecture repositoryLecture, RepositoryPerson dataPerson) {
        this.repositoryLecture = repositoryLecture;
        this.dataPerson = dataPerson;
        Scanner scanner = new Scanner(System.in);
        boolean exitBoolean = false;
        while (!exitBoolean) {

            System.out.println("Виберіть номер категорії з якою будете працювати:");
            System.out.println("1. Курс");
            System.out.println("2. Персони");
            System.out.println("3. Лекції");
            System.out.println("4. Вихід");

            int number = scanner.nextInt();

            switch (number) {
                case 1 -> {
                    System.out.println("Ви вибрали категорію : Курс");
                    exitBoolean = exitProgram();
                }
                case 2 -> {
                    System.out.println("Ви вибрали категорію : Вчителі та Студенти");
                    PersonService serPerson = new PersonService();
                    serPerson.menuPerson(dataPerson);
                }
                case 3 -> {
                    System.out.println("Ви вибрали категорію : Лекції");
                    LecturesService serLecture = new LecturesService();
                    serLecture.menuLecrute(repositoryLecture, dataPerson);
                }
                case 4 -> {
                    exitBoolean = exitProgram();
                    System.out.println("Дякую");
                }
                default -> System.out.println("Такої категорії не існує");
            }
        }
        scanner.close();
    }

    public RepositoryPerson getDataPerson() {
        return dataPerson;
    }
}

