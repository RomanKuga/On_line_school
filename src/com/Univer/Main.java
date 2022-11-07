package com.Univer;


import com.Univer.models.Course;
import com.Univer.models.Lecture;

public class Main {
    public static void main(String[] args) {
       /* Teacher teacher= new Teacher("Ivan", "Ivanov", "engineer");
        Teacher oldTeacher= new Teacher("Petro", "Petrov", "chemist");
        Teacher docent = new Teacher("Semen", "Ivanov", "philosopher");

        Course oneCourse= new Course();

        Course twoCourse= new Course();


        System.out.println(Teacher.calc);

        System.out.println(Course.calc1);*/
        Course id = new Course();
        int idCourse = id.Course(245);
        Lecture oneLectures = new Lecture( idCourse,"quadratic equations");
        Lecture twoLectures = new Lecture( idCourse,"equations");
        Lecture threeLectures = new Lecture( idCourse,"line equations part 1");
        Lecture fourLectures = new Lecture( idCourse,"line equations part 2");
        Lecture fiveLectures = new Lecture( idCourse,"line equations part 3");
        Lecture sixLectures = new Lecture( idCourse,"line equations part 4");






        System.out.println("id - 6-ї лекцій = " + idCourse);
        System.out.println("Кількість лекцій  = " + Lecture.calc);





    }
}