package com.Univer;

import com.Univer.models.Course;
import com.Univer.models.Lectures;
import com.Univer.models.Teacher;


public class Main {
    public static void main(String[] args) {
       /* Teacher teacher= new Teacher("Ivan", "Ivanov", "engineer");
        Teacher oldTeacher= new Teacher("Petro", "Petrov", "chemist");
        Teacher docent = new Teacher("Semen", "Ivanov", "philosopher");

        Course oneCourse= new Course();
        Course twoCourse= new Course();  */

        Lectures oneLectures = new Lectures("quadratic equations");
        Lectures twoLectures = new Lectures("equations");
        Lectures threeLectures = new Lectures("line equations 1 part");

        Lectures fourLectures = new Lectures("line equations 2 part");
        Lectures fiveLectures = new Lectures("line equations 3 part");


       // System.out.println(Teacher.calc);

        //System.out.println(Course.calc1);

        System.out.println(Lectures.calc);



    }
}