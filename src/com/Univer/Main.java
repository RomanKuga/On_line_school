package com.Univer;


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

        Lectures oneLectures = new Lectures("quadratic equations");
        Lectures twoLectures = new Lectures("equations");
        Lectures threeLectures = new Lectures("line equations part 1");
        Lectures fourLectures = new Lectures("line equations part 2");
        Lectures fiveLectures = new Lectures("line equations part 3");






        System.out.println(Lectures.calc);




    }
}