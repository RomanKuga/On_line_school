package com.univer;

import com.univer.models.*;
import com.univer.repository.*;
import com.univer.service.GlobalMenu;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(1, "History");
        RepositoryCourse dataCourse = RepositoryCourse.getInstance();
        dataCourse.getCourseList().add(course);
        dataCourse.getCourseList().add(new Course(2,"Ukraine history"));
        dataCourse.getCourseList().add(new Course(3,"Algebra"));
        dataCourse.getCourseList().add(new Course(4,"Geometry"));

        Lecture lectureExample = new Lecture();


        HomeWork homeWork= (new HomeWork(1, 1, "test"));
         RepositoryHomeWork tempHomeWork = RepositoryHomeWork.getInstance() ;
        tempHomeWork.getModelsList().add(homeWork);
         tempHomeWork.getModelsList().add(new HomeWork(2, 2, "test1"));
        tempHomeWork.getModelsList().add(new HomeWork(3, 1, "test2"));
        tempHomeWork.getModelsList().add(new HomeWork(4, 2, "test3"));
        tempHomeWork.getModelsList().add(new HomeWork(5, 1, "test4"));
    

        RepositoryLecture repositoryLecture = RepositoryLecture.getInstance();
        repositoryLecture.getModelsList().add(new Lecture(1, course.getCourseID(), "quadratic equations", 1, "Wers1", tempHomeWork));
        repositoryLecture.getModelsList().add(new Lecture(2, course.getCourseID(), "equations", 1, "Wers2", null));
        repositoryLecture.getModelsList().add(new Lecture(3, course.getCourseID(), "line equations part 1", 12, "Wers3", null));
        repositoryLecture.getModelsList().add(new Lecture(4, course.getCourseID(), "line equations part 2", 11, "Wers4", null));
        repositoryLecture.getModelsList().add(new Lecture(5, course.getCourseID(), "line equations part 3", 2, "Wers5", null));
        repositoryLecture.getModelsList().add(new Lecture(6, course.getCourseID(), "line equations part 4", 2, "Wers6", null));

        repositoryLecture.getModelsList().add(2,null);

        System.out.println("id курсу - 6-ї лекцій = " + Lecture.getCourseIDLecture());
        System.out.println("Кількість лекцій  = " + lectureExample.getCalcLecture());
        RepositoryPerson dataPerson = RepositoryPerson.getInstance();
        dataPerson.getModelsList().add(new Person(1, 1, Role.Teacher, "sfsdgg", "sdggagas", "0991234567", "wert@gmail.com"));
        dataPerson.getModelsList().add(new Person(2, 1, Role.Teacher, "hgkgkk", "bvnc", "0502345678", "asdf@gmail.com"));
        dataPerson.getModelsList().add(new Person(4, 1, Role.Teacher, "sooiiiuu", "lkjhg", "0502345328", "asd12f@gmail.com"));

        RepositoryAddMaterial addMaterial = RepositoryAddMaterial.getInstance();
        addMaterial.getModelsList().add(new AddMaterial(3, "quadratic equations",1,ResourceType.BOOK));
        addMaterial.getModelsList().add(new AddMaterial(2, " equations",3,ResourceType.URL));
        addMaterial.getModelsList().add(new AddMaterial(1, "quadratic equations 2",2,ResourceType.VIDEO));
        addMaterial.getModelsList().add(new AddMaterial(1, "agssfs",2,ResourceType.VIDEO));
        addMaterial.getModelsList().add(new AddMaterial(2, " aequations",3,ResourceType.URL));

        GlobalMenu glMenu = new GlobalMenu();
        glMenu.globalMenu(repositoryLecture, dataPerson,tempHomeWork,addMaterial, dataCourse);

    }

}
