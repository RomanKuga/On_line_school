package com.univer.service;

import com.univer.errorMenuService.ErrorTestNumber;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.*;
import com.univer.repository.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

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
        Lecture lectureExample = new Lecture();
        int numberNext = 1;
        while (numberNext < 2) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до меню Лекцій ", LocalDateTime.now());

            System.out.println("1. Добавити лекцію");
            System.out.println("2. Відкрити вибрану лекцію");
            System.out.println("3. Видалити вибрану лекцію");
            System.out.println("4. Вивести лекції на екран");
            System.out.println("5. Вивести список лекцій на екран ,без елементів масива із значенням null ");
            System.out.println("6. Виберіть LEVEL для запису логів у файл");
            System.out.println("7. Повернутись в основне меню");

            LecturesService pt = new LecturesService();
            ErrorTestNumber test = new ErrorTestNumber();

            switch (test.testInt()) {
                case 1:
                    pt.lectureServiceAdd(repositoryLecture);
                    break;
                case 2:
                    System.out.println("Ви вибрали відкрити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
                            " / ведіть номер лекції від 0 до " + (lectureExample.getCalcLecture()-1));
                    int numberLect = test.testInt();
                    System.out.println(repositoryLecture.getModelsList().get(numberLect));
                    if (repositoryLecture.getModelsList().get(numberLect) != null) {
                        System.out.println(createMapHomeWork(homeWork).get(numberLect+1));
                        System.out.println(createMapHomeWork(addMaterial).get(numberLect+1));
                    }
                    break;
                case 3:
                    System.out.println("Ви вибрали видалити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
                            " / ведіть номер лекції від 0 до " + (lectureExample.getCalcLecture()-1));
                    numberLect = test.testInt();
                    repositoryLecture.getModelsList().remove(numberLect);
                    for (int i=0; i<addMaterial.getModelsList().size(); i++){
                        if ((numberLect+1)==addMaterial.getModelsList().get(i).getLectureId()){
                            addMaterial.getModelsList().remove(i);
                            i--;
                        }
                    }
                    for (int i=0; i<homeWork.getModelsList().size(); i++){
                        if ((numberLect+1)==homeWork.getModelsList().get(i).getLectureId()){
                            homeWork.getModelsList().remove(i);
                            i--;
                        }
                    }
                    pt.printArray(repositoryLecture.getModelsList());
                    break;
                case 4:
                    pt.printArray(repositoryLecture.getModelsList());
                    break;
                case 5:
                    pt.printArray( repositoryLecture.findAll());
                    break;
                case 6:
                    AdjustmentLogFile menuALF= new AdjustmentLogFile();
                    menuALF.AdjustmentLogFile();
                    break;
                case 7:
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
        ErrorTestNumber testing = new ErrorTestNumber();
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
     public Map<Integer,List <MasterModels>> createMapHomeWork (RepositoryMaster master) throws IOException {
         LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Побудова Map ", LocalDateTime.now());
        Map<Integer, List<MasterModels>> mapHomeWork = new HashMap<>();
        for(int i=0; i<repositoryLecture.getModelsList().size(); i++) {
            List<MasterModels> tempList = new ArrayList<>();
            if (repositoryLecture.getModelsList().get(i)!= null) {
            for (int j=0; j<master.getModelsList().size(); j++) {
                MasterModels tempHome =  master.getModelsList().get(j);

                    if (repositoryLecture.getModelsList().get(i).getID() == tempHome.getLectureId()) {
                        tempList.add(master.getModelsList().get(j));
                    }
                }
            mapHomeWork.put(repositoryLecture.getModelsList().get(i).getID(), tempList);
            }
        }
         LogCreateObject.logDebug(this.getClass().getName(), LogLevel.DEBUG.name(), "Map - побудована ", LocalDateTime.now());
        return mapHomeWork;
     }



}
