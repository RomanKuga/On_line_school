package com.univer.service;

import com.univer.errorMenuService.ErrorTestNumber;
import com.univer.models.Course;
import com.univer.models.MasterModels;
import com.univer.repository.RepositoryCourse;

import java.io.IOException;
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
            System.out.println("4. Вивести список курсів на екран");
            System.out.println("5. Вивести список курсів на екран ,без елементів масива із значенням null ");
            System.out.println("6. Відсортувати список курсів за назвою");
            System.out.println("7. Виберіть LEVEL для запису логів у файл");
            System.out.println("8. Повернутись в основне меню");
            ErrorTestNumber testing = new ErrorTestNumber();
            int numberPers = testing.testInt();
            CourseService pt = new CourseService();

            switch (numberPers) {
                case 1:
                    pt.courseServiceAdd(dataCourse);
                    break;
                case 2:
                    System.out.println("Ви вибрали відкрити персони, кількість персон-" + courseExample.getCalcCourse() +
                            " / ведіть номер персони від 0 до " + (courseExample.getCalcCourse() - 1));
                    numberPers = testing.testInt();
                    System.out.println(dataCourse.getModelsList().get(numberPers));
                    break;
                case 3:
                    System.out.println("Ви вибрали видалити персону, кількість персон-" + courseExample.getCalcCourse() +
                            " / ведіть номер персони від 0 до " + (courseExample.getCalcCourse() - 1));
                    numberPers = testing.testInt();
                    this.dataCourse.getModelsList().remove(numberPers);
                    pt.printArray(this.dataCourse.getModelsList());
                    break;
                case 4:
                    pt.printArray(this.dataCourse.getModelsList());
                    break;
                case 5:
                    pt.printArray(this.dataCourse.findAll());
                    break;
                case 6:
                    TreeSet<MasterModels> sortCourseList = new TreeSet<>(dataCourse.getModelsList());
                    pt.printTreeSet(sortCourseList);
                    break;
                case 7:
                    AdjustmentLogFile menuALF= new AdjustmentLogFile();
                    menuALF.AdjustmentLogFile();
                    break;
                case 8:
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
        ErrorTestNumber testing = new ErrorTestNumber();
        int number = testing.testInt();
        ServiceValidator test = new ServiceValidator();
        if ((test.validatorNumber(number)) && (number == 2)) {
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
