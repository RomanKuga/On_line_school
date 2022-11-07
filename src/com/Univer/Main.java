package com.Univer;


import com.Univer.models.Course;
import com.Univer.models.Lectures;

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
        Lectures oneLectures = new Lectures( idCourse,"quadratic equations");
        Lectures twoLectures = new Lectures( idCourse++,"equations");
        Lectures threeLectures = new Lectures( idCourse++,"line equations part 1");
        Lectures fourLectures = new Lectures( idCourse++,"line equations part 2");
        Lectures fiveLectures = new Lectures( idCourse++,"line equations part 3");
        Lectures sixLectures = new Lectures( idCourse++,"line equations part 4");






        System.out.println("id - 6-ї лекцій = " + idCourse);
        System.out.println("Кількість лекцій  = " + Lectures.calc);





    }
}