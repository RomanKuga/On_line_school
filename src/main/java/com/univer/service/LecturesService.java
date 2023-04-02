package com.univer.service;

import com.univer.errorMenuService.ValidationUtil;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.*;
import com.univer.repository.RepositoryAddMaterial;
import com.univer.repository.RepositoryHomeWork;
import com.univer.repository.RepositoryLecture;
import com.univer.repository.RepositoryPerson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LecturesService {
    private RepositoryLecture repositoryLecture;
    private RepositoryPerson dataPerson;
    private RepositoryHomeWork homeWork;


    public void printArray(List<MasterModels> lect) throws IOException {
        System.out.println(lect);
        LogCreateObject.logDebug(this.getClass().getName(), LogLevel.DEBUG.name(), "Вивід списку на екран ", LocalDateTime.now());
    }


    public void menuLecrute(RepositoryLecture dataMaster, RepositoryPerson dataPerson, RepositoryHomeWork homeWork, RepositoryAddMaterial addMaterial) throws IOException {
        this.repositoryLecture = dataMaster;
        this.dataPerson = dataPerson;
        this.homeWork = homeWork;
     //   Lecture lectureExample = new Lecture();
        int numberNext = 1;
        while (numberNext < 2) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до меню Лекцій ", LocalDateTime.now());

            System.out.println("1. Добавити лекцію");
            System.out.println("2. Відкрити вибрану лекцію");
            System.out.println("3. Видалити вибрану лекцію");
            System.out.println("4. Вивести лекції на екран");
            System.out.println("5. Вивести список лекцій на екран ,без елементів масива із значенням null ");
            System.out.println("6. Виберіть LEVEL для запису логів у файл");
            System.out.println("7. Виведення лекцій на екран за датами");
            System.out.println("8. Повернутись в основне меню");

            LecturesService pt = new LecturesService();
            ValidationUtil test = new ValidationUtil();

            switch (test.testInt()) {
                case 1:
                    pt.lectureServiceAdd(repositoryLecture);
                    break;
                case 2:
////                    System.out.println("Ви вибрали відкрити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
////                            " / ведіть номер лекції від 0 до " + (lectureExample.getCalcLecture() - 1));
////                    int numberLect = test.testInt();
////                    System.out.println(repositoryLecture.getModelsList().get(numberLect));
//                    if (repositoryLecture.getModelsList().get(numberLect) != null) {
//                        System.out.println(RepositoryHomeWork.getInstance().createMapHomeWork().get(numberLect + 1));
//                        System.out.println(RepositoryAddMaterial.getInstance().createMapAddMaterial().get(numberLect + 1));
//                    }
//                    break;
//                case 3:
//                    System.out.println("Ви вибрали видалити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
//                            " / ведіть номер лекції від 0 до " + (lectureExample.getCalcLecture() - 1));
//                    numberLect = test.testInt();
//                    repositoryLecture.getModelsList().remove(numberLect);
//                    for (int i = 0; i < addMaterial.getModelsList().size(); i++) {
//                        if ((numberLect + 1) == addMaterial.getModelsList().get(i).getLectureId()) {
//                            addMaterial.getModelsList().remove(i);
//                            i--;
//                        }
//                    }
//                    for (int i = 0; i < homeWork.getModelsList().size(); i++) {
//                        if ((numberLect + 1) == homeWork.getModelsList().get(i).getLectureId()) {
//                            homeWork.getModelsList().remove(i);
//                            i--;
//                        }
//                    }
                    pt.printArray(repositoryLecture.getModelsList());
                    break;
                case 4:
                    pt.printArray(repositoryLecture.getModelsList());
                    break;
                case 5:
                    pt.printArray(repositoryLecture.findAll());
                    break;
                case 6:
                    new AdjustmentLogFile().menuAdjustmentLogFile();
                    break;
                case 7:
                    sortLectureForTime();
                    break;
                case 8:
                    numberNext = 2;
                    break;
                default:
                    System.out.println("Такої категорії не існує");
            }
        }

    }

    public void lectureServiceAdd(RepositoryLecture dataMaster) throws IOException {
        this.repositoryLecture = dataMaster;
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Добавлення нової лекції ", LocalDateTime.now());

        int arrayNumber = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                 Добавити лекцію -                        1 
                Добавити лекцію вказавши місце в масиві - 2""");
        System.out.println("Розмір масива лекції " + repositoryLecture.getModelsList().size());
        ValidationUtil testing = new ValidationUtil();
        int numberLect = new ServiceValidator().validatorNumber();


        if (numberLect == 2) {
            System.out.println("Введіть номер в масиві");
            arrayNumber = testing.testInt();
        }
        System.out.println("Введіть ID курсу");
        int courseNumber = testing.testInt();
        System.out.println("Введіть назву лекції");
        String nameLecture = scanner.next();
        System.out.println("Введіть ID лекції");
        int lectureId = testing.testInt();
        System.out.println("Введіть ID викладача із списку");
        Role role = Role.Teacher;
        Iterator<MasterModels> iterator = RepositoryPerson.getInstance().getModelsList().iterator();
        while (iterator.hasNext()) {
            Person personTmp = (Person) iterator.next();
            if ((personTmp != null) && (personTmp.getRole() == role)) {
                System.out.println(personTmp);
            }
        }
        int personID = testing.testInt();
        System.out.println("Введіть опис лекції");
        String description = scanner.next();
        System.out.println("""
                Домашнє завдання до лекції задавати?
                 Так - 1
                 Ні  - 2""");
        int numberWork = new ServiceValidator().validatorNumber();

        if (numberWork == 1) {
            System.out.println("Введіть ID домашнього завдання");
            int homeId = testing.testInt();
            System.out.println("Введіть домашнє завтання");
            String homeTask = scanner.next();
            RepositoryHomeWork.getInstance().getModelsList().add(new HomeWork(homeId, lectureId, homeTask));
        } else {
            RepositoryHomeWork.getInstance().getModelsList().add(null);
        }
        System.out.println("Введіть дату та час проведення лекції(формат дати такий : dd.MM.yyyy HH:mm)");
        scanner.nextLine();

        LocalDateTime finaleDateTimeLecture = new ServiceValidator().validatorTime(scanner.nextLine());
        if (numberLect == 2) {
            repositoryLecture.getModelsList().add(arrayNumber, new Lecture(lectureId, courseNumber, nameLecture, personID, description, homeWork, finaleDateTimeLecture));
        }

        repositoryLecture.getModelsList().add(new Lecture(lectureId, courseNumber, nameLecture, personID, description, homeWork, finaleDateTimeLecture));


    }

    public void sortLectureForTime() throws IOException {
        Scanner scanner = new Scanner(System.in);
        int numberNext = 1;
        while (numberNext < 2) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до меню Лекцій Дата", LocalDateTime.now());

            System.out.println("1. Список лекцій починаючи з введеної дати");
            System.out.println("2. Список лекцій закінчуючи  введеною датою");
            System.out.println("3. Список лекцій між двома датами");
            System.out.println("4. Повернутись в меню");


            ValidationUtil test = new ValidationUtil();
            List lectureList = RepositoryLecture.getInstance().getModelsList();
            List<Lecture> lectureList1 = lectureList;
            switch (test.testInt()) {
                case 1:
                    System.out.println("Введіть дату та час проведення лекції(формат дати такий : dd.MM.yyyy HH:mm)");
                     LocalDateTime finaleDateTimeLecture = new ServiceValidator().validatorTime(scanner.nextLine());

                    lectureList1.forEach(element -> {
                        if ((element != null) && (element.getHoldingTimeLecture().isAfter(finaleDateTimeLecture))) {
                            System.out.println(element);
                        }
                    });
                    break;
                case 2:
                    System.out.println("Введіть дату та час проведення лекції(формат дати такий : dd.MM.yyyy HH:mm)");
                    finaleDateTimeLecture = new ServiceValidator().validatorTime(scanner.nextLine());
                    lectureList1.forEach(element -> {
                        if ((element != null) && (element.getHoldingTimeLecture().isBefore(finaleDateTimeLecture))) {
                            System.out.println(element);
                        }
                    });
                    break;
                case 3:
                    boolean valid = false;
                    while (!valid) {
                        System.out.println("Введіть дату та час початку проведення лекції(формат дати такий : dd.MM.yyyy HH:mm)");
                        LocalDateTime finaleDateTimeLecture1 = new ServiceValidator().validatorTime(scanner.nextLine());
                        System.out.println("Введіть дату та час кінця проведення лекції(формат дати такий : dd.MM.yyyy HH:mm)");
                        LocalDateTime finaleDateTimeLecture2 = new ServiceValidator().validatorTime(scanner.nextLine());
                        if (finaleDateTimeLecture1.isBefore(finaleDateTimeLecture2)) {
                            lectureList1.forEach(element -> {
                                        if ((element != null) && (element.getHoldingTimeLecture().isAfter(finaleDateTimeLecture1))&&(element.getHoldingTimeLecture().isBefore(finaleDateTimeLecture2))) {
                                            System.out.println(element);
                                        }
                                    });
                            valid = true;
                        }
                        System.out.println("Початкова дата пізніше ніж кінцева");
                    }
                    break;
                case 4:
                    numberNext = 2;
                    break;

                default:
                    System.out.println("Такої категорії не існує");
            }
        }
    }

}
