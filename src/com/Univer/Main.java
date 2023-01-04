package com.Univer;

import com.Univer.models.Course;
import com.Univer.models.Lecture;
import com.Univer.repository.DataLecture;
import com.Univer.repository.DataPerson;
import com.Univer.service.GlobalMenu;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(1);

           Lecture lectureExample = new Lecture();

        DataLecture dataLecture = new DataLecture();
        dataLecture.add(new Lecture(1, course.getCourseID(), "quadratic equations",1));
        dataLecture.add(new Lecture( 2, course.getCourseID(),"equations",1));
        dataLecture.add(new Lecture( 3, course.getCourseID(),"line equations part 1",12));
        dataLecture.add(new Lecture( 4, course.getCourseID(),"line equations part 2",11));
        dataLecture.add(new Lecture(5, course.getCourseID(),"line equations part 3",2));
        dataLecture.add(new Lecture( 6, course.getCourseID(),"line equations part 4",2));

        System.out.println("id курсу - 6-ї лекцій = " +lectureExample.getCourseIDLecture());
        System.out.println("Кількість лекцій  = " +lectureExample.getCalcLecture());
        DataPerson dataPerson = new DataPerson();
        GlobalMenu glMenu=new GlobalMenu();
        glMenu.globalMenu(dataLecture,dataPerson);

    }

}
