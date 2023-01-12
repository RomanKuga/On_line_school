package com.univer;

import com.univer.models.Course;
import com.univer.models.Lecture;
import com.univer.models.Person;
import com.univer.models.Role;
import com.univer.repository.RepositoryLecture;
import com.univer.repository.RepositoryPerson;
import com.univer.service.GlobalMenu;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(1, "History");

           Lecture lectureExample = new Lecture();

        RepositoryLecture repositoryLecture = new RepositoryLecture();
        repositoryLecture.add(new Lecture(1, course.getCourseID(), "quadratic equations",1,"Wers1"));
        repositoryLecture.add(new Lecture( 2, course.getCourseID(),"equations",1,"Wers2"));
        repositoryLecture.add(new Lecture( 3, course.getCourseID(),"line equations part 1",12,"Wers3"));
        repositoryLecture.add(new Lecture( 4, course.getCourseID(),"line equations part 2",11,"Wers4"));
        repositoryLecture.add(new Lecture(5, course.getCourseID(),"line equations part 3",2,"Wers5"));
        repositoryLecture.add(new Lecture( 6, course.getCourseID(),"line equations part 4",2,"Wers6"));

        System.out.println("id курсу - 6-ї лекцій = " +lectureExample.getCourseIDLecture());
        System.out.println("Кількість лекцій  = " +lectureExample.getCalcLecture());
        RepositoryPerson dataPerson = new RepositoryPerson();
        dataPerson.personToAdd(new Person(1, 1, Role.Teacher, "sfsdgg", "sdggagas","0991234567","wert@gmail.com"));
        dataPerson.personToAdd(new Person(2, 1, Role.Teacher, "hgkgkk", "bvnc","0502345678","asdf@gmail.com"));
        dataPerson.personToAdd(new Person(4, 1, Role.Teacher, "sooiiiuu", "lkjhg","0502345328","asd12f@gmail.com"));
        GlobalMenu glMenu=new GlobalMenu();
        glMenu.globalMenu(repositoryLecture,dataPerson);

    }

}
