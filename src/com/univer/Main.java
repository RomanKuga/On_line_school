package com.univer;

import com.univer.models.*;
import com.univer.repository.RepositoryCourse;
import com.univer.repository.RepositoryHomeWork;
import com.univer.repository.RepositoryLecture;
import com.univer.repository.RepositoryPerson;
import com.univer.service.GlobalMenu;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(1, "History");

        RepositoryCourse.getInstance().add(course);


        Lecture lectureExample = new Lecture();

         HomeWork homeWor= (new HomeWork(1, 1, "test"));
         RepositoryHomeWork tempHomeWork = new RepositoryHomeWork() ;
         tempHomeWork.add(homeWor);

     //   homeWork.add(new HomeWork(1, 1, "test"));

        RepositoryLecture repositoryLecture = new RepositoryLecture();
        repositoryLecture.add(new Lecture(1, course.getCourseID(), "quadratic equations", 1, "Wers1", tempHomeWork));

        repositoryLecture.add(new Lecture(2, course.getCourseID(), "equations", 1, "Wers2", null));
        repositoryLecture.add(new Lecture(3, course.getCourseID(), "line equations part 1", 12, "Wers3", null));
        repositoryLecture.add(new Lecture(4, course.getCourseID(), "line equations part 2", 11, "Wers4", null));
        repositoryLecture.add(new Lecture(5, course.getCourseID(), "line equations part 3", 2, "Wers5", null));
        repositoryLecture.add(new Lecture(6, course.getCourseID(), "line equations part 4", 2, "Wers6", null));

        System.out.println("id курсу - 6-ї лекцій = " + Lecture.getCourseIDLecture());
        System.out.println("Кількість лекцій  = " + lectureExample.getCalcLecture());
        RepositoryPerson dataPerson = new RepositoryPerson();
        dataPerson.add(new Person(1, 1, Role.Teacher, "sfsdgg", "sdggagas", "0991234567", "wert@gmail.com"));
        dataPerson.add(new Person(2, 1, Role.Teacher, "hgkgkk", "bvnc", "0502345678", "asdf@gmail.com"));
        dataPerson.add(new Person(4, 1, Role.Teacher, "sooiiiuu", "lkjhg", "0502345328", "asd12f@gmail.com"));
        GlobalMenu glMenu = new GlobalMenu();
        glMenu.globalMenu(repositoryLecture, dataPerson,tempHomeWork);

    }

}
