package com.univer.service;

import com.univer.models.Lecture;
import com.univer.models.MasterModels;
import com.univer.models.Role;
import com.univer.repository.RepositoryLecture;
import com.univer.repository.RepositoryPerson;

import java.util.Arrays;
import java.util.Scanner;

public class LecturesService {
    private RepositoryLecture repositoryLecture;

    public void printArray(MasterModels[] lect) {

        System.out.println(Arrays.toString(lect));
    }

    public void menuLecrute(RepositoryLecture dataMaster, RepositoryPerson dataPerson) {
        this.repositoryLecture = dataMaster;

        Lecture lectureExample = new Lecture();
        int numberNext = 1;
        while (numberNext < 2) {

            System.out.println("1. Добавити лекцію");
            System.out.println("2. Відкрити вибрану лекцію");
            System.out.println("3. Видалити вибрану лекцію");
            System.out.println("4. Вивести лекції на екран");
            System.out.println("5. Повернутись в основне меню");

            Scanner scanner = new Scanner(System.in);
            int numberLect = scanner.nextInt();
            LecturesService pt = new LecturesService();

            switch (numberLect) {
                case 1:
                    if (lectureExample.getID() < 8) {
                        System.out.println("Введіть ID курсу");
                        int courseNumber = scanner.nextInt();
                        System.out.println("Введіть назву лекції");
                        String nameLecture = scanner.next();
                        System.out.println("Введіть ID лекції");
                        int lectureId = scanner.nextInt();
                        System.out.println("Введіть ID викладача із списку");
                        Role role = Role.Teacher;
//                        for (Person person : dataPerson.getPerson()) {
//                            if ((person != null) && (person.getRole() == role)) {
//                                System.out.println(person.toString());
//                            }
//                        }
                        int personID = scanner.nextInt();
                        System.out.println("Введіть опис лекції");
                        String description = scanner.next();

                        repositoryLecture.add(new Lecture(lectureId, courseNumber, nameLecture, personID, description));
                        break;
                    } else {
                        System.out.println("Кількість лекцій перевищує 8 ");
                        numberNext = 2;
                        break;
                    }
                case 2:
                    System.out.println("Ви вибрали відкрити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
                            " / ведіть номер лекції від 1 до " + lectureExample.getCalcLecture());
                    numberLect = scanner.nextInt();
//                    repositoryLecture.getByld(numberLect);
//                    Lecture lecture = repositoryLecture.getLectures()[repositoryLecture.getIndex()];
//                    for (Person person : dataPerson.getPerson()) {
//                        if ((person != null) && (person.getPersonID() == lecture.getLecturePersonId())) {
//                            System.out.println(person.toString());
//                        }
//                    }

                    break;
                case 3:
                    System.out.println("Ви вибрали видалити лекцію, кількість лекцій-" + lectureExample.getCalcLecture() +
                            " / ведіть номер лекції від 1 до " + lectureExample.getCalcLecture());
                    numberLect = scanner.nextInt();
//                    repositoryLecture.deleteByld(numberLect);
//                    pt.printArray(repositoryLecture.getLectures());
                    break;
                case 4:
                    pt.printArray(repositoryLecture.getLectures());
                    break;
                case 5:
                    numberNext = 2;
                    break;
                default:
                    System.out.println("Такої категорії не існує");
            }
        }
    }

}
