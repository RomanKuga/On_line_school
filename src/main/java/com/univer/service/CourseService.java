package com.univer.service;

import com.univer.backup.BackupCourseAndParameter;
import com.univer.errorMenuService.ValidationUtil;
import com.univer.models.*;
import com.univer.repository.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class CourseService {
    private RepositoryCourse dataCourse;

    public void printArray(List<MasterModels> cours) {
        System.out.println(cours);
    }

    public void printTreeSet(TreeSet<MasterModels> cours) {
        System.out.println(cours);
    }

    public void menuCourse(RepositoryCourse dataCourse) throws IOException {
        this.dataCourse = dataCourse;
        Course courseExample = new Course();
        int numberNext = 1;
        while (numberNext < 2) {

            System.out.println("1. Добавити курс");
            System.out.println("2. Відкрити курс");
            System.out.println("3. Видалити курс");
            System.out.println("4. Вивести список курсів на екран ,без елементів масива із значенням null ");
            System.out.println("5. Відсортувати список курсів за назвою");
            System.out.println("6. Виберіть LEVEL для запису логів у файл");
            System.out.println("7. Зробити backup курсу з відповідними лекціями, домашнім, додатковим, викладачами та студентами");
            System.out.println("8. Вивести на екран вміст backup.txt файлу ");
            System.out.println("9. Повернутись в основне меню");
            ValidationUtil testing = new ValidationUtil();
            int numberPers = testing.testInt();
            CourseService pt = new CourseService();

            switch (numberPers) {
                case 1:
                    pt.courseServiceAdd(dataCourse);
                    break;
                case 2:
                    System.out.println("Ви вибрали відкрити курс, кількість курсів-" + courseExample.getCalcCourse() +
                            " / ведіть номер курсу від 0 до " + (courseExample.getCalcCourse() - 1));
                    numberPers = testing.testInt();
                    while  (numberPers > courseExample.getCalcCourse()-1) {
                        System.out.println("Ввели номер, який не є впроміжку номерів курсу, спробуйте ще");
                        numberPers = testing.testInt();
                    }
                    System.out.println(dataCourse.getModelsList().get(numberPers));
                    break;
                case 3:
                    System.out.println("Ви вибрали видалити курс, кількість курсів-" + courseExample.getCalcCourse() +
                            " / ведіть номер курсу від 0 до " + (courseExample.getCalcCourse() - 1));
                    numberPers = testing.testInt();
                    while  (numberPers > courseExample.getCalcCourse()-1) {
                        System.out.println("Ввели номер, який не є впроміжку номерів курсу, спробуйте ще");
                        numberPers = testing.testInt();
                    }
                    this.dataCourse.getModelsList().remove(numberPers);
                    pt.printArray(this.dataCourse.getModelsList());
                    break;
                case 4:
                    pt.printArray(this.dataCourse.findAll());
                    break;
                case 5:
                    TreeSet<MasterModels> sortCourseList = new TreeSet<>(dataCourse.getModelsList());
                    pt.printTreeSet(sortCourseList);
                    break;
                case 6:
                    new AdjustmentLogFile().menuAdjustmentLogFile();

                    break;
                case 7:
                    System.out.println("Ви вибрали backup курсу, кількість курсів-" + courseExample.getCalcCourse() +
                            " / ведіть номер курсу від 1 до " + courseExample.getCalcCourse());
                    numberPers = testing.testInt();
                    while ((numberPers == 0) || (numberPers > courseExample.getCalcCourse())) {
                        System.out.println("Ввели номер, який не є впроміжку номерів курсу, спробуйте ще");
                        numberPers = testing.testInt();
                    }
                    List<Lecture> tempLecture = RepositoryLecture.getInstance().createMapLecture().get(numberPers);
                    List<HomeWork> newTempHomeWork = new ArrayList<>();
                    List<AddMaterial> newTempAddMaterial = new ArrayList<>();
                    for (Lecture element : tempLecture) {
                        if ((RepositoryHomeWork.getInstance().createMapHomeWork().get(element.getID()) != null) &&
                                (!RepositoryHomeWork.getInstance().createMapHomeWork().get(element.getID()).isEmpty())) {
                            newTempHomeWork.addAll(RepositoryHomeWork.getInstance().createMapHomeWork().get(element.getID()));
                        }
                        if ((RepositoryAddMaterial.getInstance().createMapAddMaterial().get(element.getID()) != null) &&
                                (!RepositoryAddMaterial.getInstance().createMapAddMaterial().get(element.getID()).isEmpty())) {
                            newTempAddMaterial.addAll(RepositoryAddMaterial.getInstance().createMapAddMaterial().get(element.getID()));
                        }
                    }
                    BackupCourseAndParameter.serializeLecture(RepositoryLecture.getInstance().createMapLecture().get(numberPers), RepositoryPerson.getInstance().createMapPerson().get(numberPers), newTempHomeWork, newTempAddMaterial);
                    break;
                case 8:
                    System.out.println(BackupCourseAndParameter.deserialize());

                    break;
                case 9:
                    numberNext = 2;
                    break;
                default:
                    System.out.println("Такої категорії не існує");
            }
        }
    }

    public void courseServiceAdd(RepositoryCourse dataCourse) throws IOException {
        this.dataCourse = dataCourse;
        int arrayNumber = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                 Добавити курс -                        1 
                Добавити курс вказавши місце в масиві - 2""");
        System.out.println("Розмір масива Курс " + dataCourse.getModelsList().size());
        ValidationUtil testing = new ValidationUtil();
        int number = new ServiceValidator().validatorNumber();

        if (number == 2) {
            System.out.println("Введіть номер в масиві");
            arrayNumber = testing.testInt();
        }
        System.out.println("Введіть ID курсу");
        int courseNumber = testing.testInt();
        System.out.println("Введіть назву курсу");
        String courseName = scanner.next();

        if (number == 2) {
            dataCourse.getModelsList().add(arrayNumber, new Course(courseNumber, courseName));
        }

        dataCourse.getModelsList().add(new Course(courseNumber, courseName));
    }
}
