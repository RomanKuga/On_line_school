package com.univer.service;

import com.univer.models.*;
import com.univer.repository.RepositoryHomeWork;
import com.univer.repository.RepositoryLecture;
import com.univer.repository.RepositoryPerson;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LecturesService {
    private RepositoryLecture repositoryLecture;
    private RepositoryPerson dataPerson;
    private RepositoryHomeWork homeWork;

    public void printArray(List<MasterModels> lect) {
        System.out.println(lect);
    }


    public void menuLecrute(RepositoryLecture dataMaster, RepositoryPerson dataPerson, RepositoryHomeWork homeWork) {
        this.repositoryLecture = dataMaster;
        this.dataPerson = dataPerson;
        this.homeWork = homeWork;
        Lecture lectureExample = new Lecture();
        int numberNext = 1;
        while (numberNext < 2) {

            System.out.println("1. Добавити лекцію");
            System.out.println("2. Відкрити вибрану лекцію");
            System.out.println("3. Видалити вибрану лекцію");
            System.out.println("4. Вивести лекції на екран");
            System.out.println("5. Вивести список лекцій на екран ,без елементів масива із значенням null ");
            System.out.println("6. Повернутись в основне меню");

            LecturesService pt = new LecturesService();
            ErrorService test = new ErrorService();

            switch (test.testInt()) {
                case 1:
                    pt.lectureServiceAdd(repositoryLecture, dataPerson, homeWork);
                    break;
                case 2:
                    System.out.println("Ви вибрали відкрити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
                            " / ведіть номер лекції від 0 до " + (lectureExample.getCalcLecture()-1));
                    int numberLect = test.testInt();
                    System.out.println(repositoryLecture.getModelsList().get(numberLect));
                    Lecture lecture = (Lecture) repositoryLecture.getModelsList().get(numberLect);
                    if (repositoryLecture.getModelsList().get(numberLect) != null) {
                        Iterator<MasterModels> iterator= dataPerson.getModelsList().iterator();
                        while (iterator.hasNext()){
                            Person personTmp= (Person) iterator.next();
                            if ((personTmp != null) && (personTmp.getID() == lecture.getLecturePersonId())) {
                                System.out.println(personTmp);
                            }
                        }
                    }

                    break;
                case 3:
                    System.out.println("Ви вибрали видалити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
                            " / ведіть номер лекції від 0 до " + (lectureExample.getCalcLecture()-1));
                    numberLect = test.testInt();
                    repositoryLecture.getModelsList().remove(numberLect);
                    pt.printArray(repositoryLecture.getModelsList());
                    break;
                case 4:
                    pt.printArray(repositoryLecture.getModelsList());
                    break;
                case 5:
                    pt.printArray( repositoryLecture.findAll());
                    break;
                case 6:
                    numberNext = 2;
                    break;
                default:
                    System.out.println("Такої категорії не існує");
            }
        }

    }

    public void lectureServiceAdd(RepositoryLecture dataMaster, RepositoryPerson dataPerson, RepositoryHomeWork homeWork) {
        this.repositoryLecture = dataMaster;

        int arrayNumber = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                 Добавити лекцію -                        1 
                Добавити лекцію вказавши місце в масиві - 2""");
        System.out.println("Розмір масива лекції " + repositoryLecture.getModelsList().size());
        ErrorService testing = new ErrorService();
        int numberLect = testing.testInt();

        ServiceValidator test = new ServiceValidator();
        if ((test.validatorNumber(numberLect)) && (numberLect == 2)) {
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
        Iterator<MasterModels> iterator= dataPerson.getModelsList().iterator();
        while (iterator.hasNext()){
            Person personTmp= (Person) iterator.next();
            if ((personTmp != null) && (personTmp.getRole() == role)) {
                System.out.println(personTmp.toString());
            }
        }
        int personID = testing.testInt();
        System.out.println("Введіть опис лекції");
        String description = scanner.next();
        System.out.println("""
                Домашнє завдання до лекції задавати?
                 Так - 1
                 Ні  - 2""");
        int numberWork = testing.testInt();

        if ((test.validatorNumber(numberWork)) && (numberWork == 1)) {
            System.out.println("Введіть ID домашнього завдання");
            int homeId = testing.testInt();
            System.out.println("Введіть домашнє завтання");
            String homeTask = scanner.next();
            homeWork.getModelsList().add(new HomeWork(homeId, lectureId, homeTask));
        } else {
            homeWork.getModelsList().add(null);
        }
        if (numberLect == 2) {
            repositoryLecture.getModelsList().add(arrayNumber, new Lecture(lectureId, courseNumber, nameLecture, personID, description, homeWork));
        }

        repositoryLecture.getModelsList().add(new Lecture(lectureId, courseNumber, nameLecture, personID, description, homeWork));

    }


}
