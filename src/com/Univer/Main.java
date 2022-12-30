package com.Univer;

import com.Univer.models.Course;
import com.Univer.models.EnumRole;
import com.Univer.models.Lecture;
import com.Univer.repository.DataLecture;
import com.Univer.service.GlobalMenu;
import com.Univer.service.LecturesService;

import java.util.Scanner;

import static com.Univer.service.ExitProgram.exitProgram;
public class Main {
    public static void main(String[] args) {

        Course course = new Course(1);

           Lecture lectureExample = new Lecture();

        DataLecture dataLecture = new DataLecture();
        dataLecture.add(new Lecture(1, course.getCourseID(), "quadratic equations"));
        dataLecture.add(new Lecture( 2, course.getCourseID(),"equations"));
        dataLecture.add(new Lecture( 3, course.getCourseID(),"line equations part 1"));
        dataLecture.add(new Lecture( 4, course.getCourseID(),"line equations part 2"));
        dataLecture.add(new Lecture(5, course.getCourseID(),"line equations part 3"));
        dataLecture.add(new Lecture( 6, course.getCourseID(),"line equations part 4"));

        System.out.println("id курсу - 6-ї лекцій = " +lectureExample.getCourseIDLecture());
        System.out.println("Кількість лекцій  = " +lectureExample.getCalcLecture());

        GlobalMenu glMenu=new GlobalMenu();
        glMenu.globalMenu(dataLecture);

    }

}
