package com.Univer;

import com.Univer.models.Lectures;
import com.Univer.models.Add_materials;
import com.Univer.models.Course;
import com.Univer.models.Teacher;
import com.Univer.models.Students;
import com.Univer.models.Home_Work;



public class Main {
    public static void main(String[] args) {
        Teacher teacher= new Teacher("Ivan", "Ivanov", "engineer");
        Teacher oldTeacher= new Teacher("Petro", "Petrov", "chemist");
        Teacher docent = new Teacher("Semen", "Ivanov", "philosopher");

        Course oneCourse= new Course();

        Course twoCourse= new Course();


        System.out.println(Teacher.calc);

        System.out.println(Course.calc1);



    }
}