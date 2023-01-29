package com.univer.service;

import com.univer.repository.RepositoryAddMaterial;
import com.univer.repository.RepositoryHomeWork;
import com.univer.repository.RepositoryLecture;
import com.univer.repository.RepositoryPerson;

import java.util.Scanner;

import static com.univer.service.ExitProgram.exitProgram;

public class GlobalMenu {
    private RepositoryLecture repositoryLecture;
    private RepositoryPerson dataPerson;
    private RepositoryHomeWork homeWork;
    private RepositoryAddMaterial addMaterial;

    public void globalMenu(RepositoryLecture repositoryLecture, RepositoryPerson dataPerson, RepositoryHomeWork homeWork, RepositoryAddMaterial addMaterial) {
        this.repositoryLecture = repositoryLecture;
        this.dataPerson = dataPerson;
        this.homeWork = homeWork;
        this.addMaterial=addMaterial;
        Scanner scanner = new Scanner(System.in);
        boolean exitBoolean = false;
        while (!exitBoolean) {

            System.out.println("Виберіть номер категорії з якою будете працювати:");
            System.out.println("1. Курс");
            System.out.println("2. Персони");
            System.out.println("3. Лекції");
            System.out.println("4. Додаткові матеріали");
            System.out.println("5. Вихід");
            ErrorService number = new ErrorService();

            switch (number.testInt()) {
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
                    serLecture.menuLecrute(repositoryLecture, dataPerson, homeWork);
                }
                case 4 -> {
                    System.out.println("Ви вибрали категорію : Додаткові матеріали");
                    AddMaterialsService serAddMaterial = new AddMaterialsService();
                    serAddMaterial.menuAddMaterials(addMaterial);
                }
                case 5 -> {
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

