package com.univer;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.*;
import com.univer.repository.*;
import com.univer.serverANDclient.MenuServAndClient;
import com.univer.service.GlobalMenu;
import com.univer.service.ServiceValidator;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {


       MenuServAndClient menuServAndClient=new MenuServAndClient();
     menuServAndClient.menuServAndClient();

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
        repositoryLecture.getModelsList().add(new Lecture(1, course.getCourseID(), "quadratic equations", 1, "Wers1", tempHomeWork, new ServiceValidator().validatorTime("10.02.2022 12:30")));
        repositoryLecture.getModelsList().add(new Lecture(2, course.getCourseID(), "equations", 1, "Wers2", null,new ServiceValidator().validatorTime("12.02.2022 12:30")));
        repositoryLecture.getModelsList().add(new Lecture(3, course.getCourseID(), "line equations part 1", 12, "Wers3", null,new ServiceValidator().validatorTime("13.02.2022 12:30")));
        repositoryLecture.getModelsList().add(new Lecture(4, course.getCourseID(), "line equations part 2", 11, "Wers4", null,new ServiceValidator().validatorTime("15.02.2022 12:30")));
        repositoryLecture.getModelsList().add(new Lecture(5, course.getCourseID(), "line equations part 3", 2, "Wers5", null,new ServiceValidator().validatorTime("17.02.2022 12:30")));
        repositoryLecture.getModelsList().add(new Lecture(6, course.getCourseID(), "line equations part 4", 2, "Wers6", null,new ServiceValidator().validatorTime("22.02.2022 12:30")));

       // repositoryLecture.getModelsList().add(2,null);


        RepositoryPerson dataPerson = RepositoryPerson.getInstance();
        dataPerson.getModelsList().add(new Person(1, 1, Role.Teacher, "Sfsdgg", "Sdggagas", "0991234567", "wert@gmail.com"));
        dataPerson.getModelsList().add(new Person(2, 1, Role.Teacher, "Hgkgkk", "Bvnc", "0502345678", "asdf@gmail.com"));
        dataPerson.getModelsList().add(new Person(3, 1, Role.Teacher, "Sooiiiuu", "Lkjhg", "0502345328", "rasd12f@gmail.com"));
        dataPerson.getModelsList().add(new Person(4, 1, Role.Student, "Petro", "sdggagas", "0991234567", "twert1@gmail.com"));
        dataPerson.getModelsList().add(new Person(5, 1, Role.Student, "Ivan", "bvnc", "0502345678", "gasdf455555@gmail.com"));
        dataPerson.getModelsList().add(new Person(6, 1, Role.Student, "Vasil", "lkjhg", "0502345328", "hasd12f1@gmail.com"));
        dataPerson.getModelsList().add(new Person(7, 1, Role.Student, "Oksana", "sdggagas", "0991234567", "dwertsddf@gmail.com"));
        dataPerson.getModelsList().add(new Person(8, 1, Role.Student, "Roman", "bvnc", "0502345678", "yasdfwer@gmail.com"));
        dataPerson.getModelsList().add(new Person(9, 1, Role.Student, "Nataliya", "lkjhg", "0502345328", "basd12f1yutr@gmail.com"));
        dataPerson.getModelsList().add(new Person(10, 1, Role.Student, "Olena", "sdggagas", "0991234567", "vwert233@gmail.com"));
        dataPerson.getModelsList().add(new Person(11, 1, Role.Student, "Boris", "lkjhg", "0502345328", "zasd12f45@gmail.com"));
        dataPerson.getModelsList().add(new Person(12, 1, Role.Student, "Misha", "lkjhg", "0502345328", "masd12f67@gmail.com"));
        dataPerson.getModelsList().add(new Person(13, 1, Role.Student, "Jana", "lkjhg", "0502345328", "iasd12f9887@gmail.com"));

        RepositoryAddMaterial addMaterial = RepositoryAddMaterial.getInstance();
        addMaterial.getModelsList().add(new AddMaterial(3, "quadratic equations",1,ResourceType.BOOK));
        addMaterial.getModelsList().add(new AddMaterial(2, " equations",3,ResourceType.URL));
        addMaterial.getModelsList().add(new AddMaterial(1, "quadratic equations 2",2,ResourceType.VIDEO));
        addMaterial.getModelsList().add(new AddMaterial(1, "agssfs",2,ResourceType.VIDEO));
        addMaterial.getModelsList().add(new AddMaterial(2, " aequations",3,ResourceType.URL));
        LogCreateObject.logInfo(Main.class.getName(), LogLevel.INFO.name(), "Внесення початкових даних ", LocalDateTime.now());

        GlobalMenu glMenu = new GlobalMenu();
        glMenu.globalMenu(repositoryLecture, dataPerson,tempHomeWork,addMaterial, dataCourse);




    }

}