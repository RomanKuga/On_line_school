package com.Univer;


import com.Univer.models.Course;
import com.Univer.models.Lecture;
import com.Univer.models.Teacher;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(1);

        Lecture lectureExample = new Lecture(1, course.getCourseID(), "quadratic equations");
        lectureExample.courseID = course.getCourseID();

        Lecture twoLectures = new Lecture( 2, lectureExample.courseID,"equations");
        Lecture threeLectures = new Lecture( 3, lectureExample.courseID,"line equations part 1");
        Lecture fourLectures = new Lecture( 4, lectureExample.courseID,"line equations part 2");
        Lecture fiveLectures = new Lecture(5, lectureExample.courseID,"line equations part 3");
        Lecture sixLectures = new Lecture( 6, lectureExample.courseID,"line equations part 4");


        System.out.println("id курсу - 6-ї лекцій = " + lectureExample.courseID);
        System.out.println("Кількість лекцій  = " + Lecture.calc);
        Scanner scanner = new Scanner(System.in);
        boolean exitBoolean = false;
        while (exitBoolean == false) {



            System.out.println("Виберіть номер категорії з якою будете працювати:");
            System.out.println("1. Курс");
            System.out.println("2. Вчителі");
            System.out.println("3. Студенти");
            System.out.println("4. Лекції");
            System.out.println("5. Вихід");

            int number = scanner.nextInt();

            switch (number) {
                case 1:
                    System.out.println("Ви вибрали категорію : Курс");
                    exitBoolean = exitProgram();
                    break;
                case 2:
                    System.out.println("Ви вибрали категорію : Вчителі");
                    exitBoolean = exitProgram();
                    break;
                case 3:
                    System.out.println("Ви вибрали категорію : Студенти");
                    exitBoolean = exitProgram();
                    break;
                case 4:
                    System.out.println("Ви вибрали категорію : Лекції");

                    int numberNext = 1;
                    while (numberNext < 2) {
                        System.out.println("id курсу -" + lectureExample.courseID + "  Кількість лекцій  = " + Lecture.calc);

                        System.out.println("Добавити лекцію?");
                        System.out.println("1. Так");
                        System.out.println("2. Ні");

                        numberNext = scanner.nextInt();


                        switch (numberNext) {
                            case 1:
                                if (Lecture.calc <8) {
                                System.out.println("Введіть ID курсу");
                                int courseNumber = scanner.nextInt();
                                Course courseNext = new Course(courseNumber);

                                System.out.println("Введіть назву лекції");
                                String nameLecture = scanner.next();
                                System.out.println("Введіть ID лекції");
                                int lectureId = scanner.nextInt();

                                Lecture lectureNext = new Lecture(lectureId, course.getCourseID(), nameLecture);
                                lectureExample.courseID = course.getCourseID();
                                break;
                                }
                                else { System.out.println("Кількість лекцій перевищує 8 ");
                                    numberNext = 2;
                                    break;
                                }
                            case 2:
                                numberNext = 2;

                                break;
                        }
                    }
                    exitBoolean = exitProgram();
                    break;
                case 5:

                    System.out.println("Дякую");
                    exitBoolean = true;
                    break;
                    default:
                    System.out.println("Такої категорії не існує");
                        break;

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