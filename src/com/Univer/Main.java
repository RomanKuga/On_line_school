package com.Univer;


import com.Univer.models.Course;
import com.Univer.models.Lecture;
import com.Univer.repository.DataLecture;
import com.Univer.service.LecturesService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(1);

           Lecture lectureExample = new Lecture();
//        Lecture twoLectures = new Lecture( 2, course.getCourseID(),"equations");
//        Lecture threeLectures = new Lecture( 3, course.getCourseID(),"line equations part 1");
//        Lecture fourLectures = new Lecture( 4, course.getCourseID(),"line equations part 2");
//        Lecture fiveLectures = new Lecture(5, course.getCourseID(),"line equations part 3");
//        System.out.println(fiveLectures.getCalcLecture());
//        Lecture sixLectures = new Lecture( 6, course.getCourseID(),"line equations part 4");
//        System.out.println(sixLectures.getCalcLecture());

        DataLecture dataLecture = new DataLecture();
        dataLecture.add(new Lecture(1, course.getCourseID(), "quadratic equations"));
        dataLecture.add(new Lecture( 2, course.getCourseID(),"equations"));
        dataLecture.add(new Lecture( 3, course.getCourseID(),"line equations part 1"));
        dataLecture.add(new Lecture( 4, course.getCourseID(),"line equations part 2"));
        dataLecture.add(new Lecture(5, course.getCourseID(),"line equations part 3"));
        dataLecture.add(new Lecture( 6, course.getCourseID(),"line equations part 4"));

        System.out.println("id курсу - 6-ї лекцій = " +lectureExample.getCourseIDLecture());
        System.out.println("Кількість лекцій  = " +lectureExample.getCalcLecture());
        Scanner scanner = new Scanner(System.in);
        boolean exitBoolean = false;
        while (!exitBoolean) {

            System.out.println("Виберіть номер категорії з якою будете працювати:");
            System.out.println("1. Курс");
            System.out.println("2. Вчителі");
            System.out.println("3. Студенти");
            System.out.println("4. Лекції");
            System.out.println("5. Вихід");

            int number = scanner.nextInt();

            switch (number) {
                case 1 -> {
                    System.out.println("Ви вибрали категорію : Курс");
                    exitBoolean = exitProgram();
                }
                case 2 -> {
                    System.out.println("Ви вибрали категорію : Вчителі");
                    exitBoolean = exitProgram();
                }
                case 3 -> {
                    System.out.println("Ви вибрали категорію : Студенти");
                    exitBoolean = exitProgram();
                }
                case 4 -> {
                    System.out.println("Ви вибрали категорію : Лекції");
                    int numberNext = 1;
                    while (numberNext < 2) {
                        System.out.println("id курсу -" + course.getCourseID() + "  Кількість лекцій  = " + lectureExample.getCalcLecture());

                        System.out.println("1. Добавити лекцію");
                        System.out.println("2. Відкрити вибрану лекцію");
                        System.out.println("3. Видалити вибрану лекцію");
                        System.out.println("4. Вивести лекції на екран");
                        System.out.println("5. Повернутись в основне меню");


                        int numberLect = scanner.nextInt();
                        LecturesService pt = new LecturesService();

                        switch (numberLect) {
                            case 1:
                                if (lectureExample.getIdLecture() < 8) {
                                    System.out.println("Введіть ID курсу");
                                    int courseNumber = scanner.nextInt();
                                    Course courseNext = new Course(courseNumber);

                                    System.out.println("Введіть назву лекції");
                                    String nameLecture = scanner.next();
                                    System.out.println("Введіть ID лекції");
                                    int lectureId = scanner.nextInt();

                                    dataLecture.add(new Lecture(lectureId, course.getCourseID(), nameLecture));
                                    break;
                                } else {
                                    System.out.println("Кількість лекцій перевищує 8 ");
                                    numberNext = 2;
                                    break;
                                }
                            case 2:
                                System.out.println("Ви вибрали відкрити лекцію, кількість лекцій-"+lectureExample.getCalcLecture()+
                                                     " / ведіть номер лекції від 1 до "+lectureExample.getCalcLecture());
                                numberLect = scanner.nextInt();
                                pt.printArray(dataLecture.getByld(numberLect));

                                break;
                            case 3:
                                System.out.println("Ви вибрали видалити лекцію, кількість лекцій-"+lectureExample.getCalcLecture()+
                                        " / ведіть номер лекції від 1 до "+lectureExample.getCalcLecture());
                                numberLect = scanner.nextInt();
                                dataLecture.deleteByld(numberLect);
                                pt.printArray(dataLecture.getLectures());
                                break;
                            case 4:

                                pt.printArray(dataLecture.getLectures());
                                break;
                            case 5:
                                numberNext = 2;
                                break;
                            default :
                                System.out.println("Такої категорії не існує");

                        }
                    }
                    exitBoolean = exitProgram();
                }
                case 5 -> {
                    System.out.println("Дякую");
                    exitBoolean = true;
                }
                default -> System.out.println("Такої категорії не існує");
            }
        }
        scanner.close();




    }
    private static boolean exitProgram(){
        boolean exitVers = false;
        Scanner nextScanner = new Scanner(System.in);
        System.out.println("Бажаєте вийти з програми");
        System.out.println("1. Так");
        System.out.println("2. Ні");
        int nextY=nextScanner.nextInt();
        switch (nextY){
            case 1:
                exitVers =true;
                break;
            case 2:
                exitVers =false;
                break;
            default:
                System.out.println("Ви не вибрали");
        }
        return exitVers;
    }
}