package com.univer;

import com.univer.config.AppConfig;
import com.univer.service.CourseSpringService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args)  {
     ApplicationContext apc = new AnnotationConfigApplicationContext(AppConfig.class);
     CourseSpringService wers=apc.getBean(CourseSpringService.class);
     System.out.println(wers.allCourse());
//     new MenuServAndClient().menuServAndClient() ;
//
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(RepositoryCourse.class);
// //       applicationContext.getBean(MenuServAndClient.class).menuServAndClient();
//
//
//
//       Course course = new Course(1, "History");
//
//        applicationContext.getBean(RepositoryCourse.class).getInstance();
//        applicationContext.getBean(RepositoryCourse.class).getCourseList().add(course);
//        applicationContext.getBean(RepositoryCourse.class).getCourseList().add(new Course(2, "Ukraine history"));
//        applicationContext.getBean(RepositoryCourse.class).getCourseList().add(new Course(3, "Algebra"));
//        applicationContext.getBean(RepositoryCourse.class).getCourseList().add(new Course(4, "Geometry"));
//
//
//        RepositoryCourse dataCourse =  applicationContext.getBean(RepositoryCourse.class);
//
//
//        HomeWork homeWork = (new HomeWork(1, 1, "test"));
//        RepositoryHomeWork tempHomeWork = RepositoryHomeWork.getInstance();
//        tempHomeWork.getModelsList().add(homeWork);
//        tempHomeWork.getModelsList().add(new HomeWork(2, 2, "test1"));
//        tempHomeWork.getModelsList().add(new HomeWork(3, 1, "test2"));
//        tempHomeWork.getModelsList().add(new HomeWork(4, 2, "test3"));
//        tempHomeWork.getModelsList().add(new HomeWork(5, 1, "test4"));
//
//
//        RepositoryLecture repositoryLecture = RepositoryLecture.getInstance();
//        repositoryLecture.getModelsList().add(new Lecture(1, course.getCourseID(), "quadratic equations", 1, "Wers1", tempHomeWork, new ServiceValidator().validatorTime("10.02.2022 12:30")));
//        repositoryLecture.getModelsList().add(new Lecture(2, course.getCourseID(), "equations", 1, "Wers2", null, new ServiceValidator().validatorTime("12.02.2022 12:30")));
//        repositoryLecture.getModelsList().add(new Lecture(3, course.getCourseID(), "line equations part 1", 12, "Wers3", null, new ServiceValidator().validatorTime("13.02.2022 12:30")));
//        repositoryLecture.getModelsList().add(new Lecture(4, course.getCourseID(), "line equations part 2", 11, "Wers4", null, new ServiceValidator().validatorTime("15.02.2022 12:30")));
//        repositoryLecture.getModelsList().add(new Lecture(5, course.getCourseID(), "line equations part 3", 2, "Wers5", null, new ServiceValidator().validatorTime("17.02.2022 12:30")));
//        repositoryLecture.getModelsList().add(new Lecture(6, course.getCourseID(), "line equations part 4", 2, "Wers6", null, new ServiceValidator().validatorTime("22.02.2022 12:30")));
//
//
//
//        RepositoryPerson dataPerson = RepositoryPerson.getInstance();
//        dataPerson.getModelsList().add(new Person(1, 1, Role.Teacher, "Sfsdgg", "Sdggagas", "0991234567", "wert@gmail.com"));
//        dataPerson.getModelsList().add(new Person(2, 1, Role.Teacher, "Hgkgkk", "Bvnc", "0502345678", "asdf@gmail.com"));
//        dataPerson.getModelsList().add(new Person(3, 1, Role.Teacher, "Sooiiiuu", "Lkjhg", "0502345328", "rasd12f@gmail.com"));
//        dataPerson.getModelsList().add(new Person(4, 1, Role.Student, "Petro", "sdggagas", "0991234567", "twert1@gmail.com"));
//        dataPerson.getModelsList().add(new Person(5, 1, Role.Student, "Ivan", "bvnc", "0502345678", "gasdf455555@gmail.com"));
//        dataPerson.getModelsList().add(new Person(6, 1, Role.Student, "Vasil", "lkjhg", "0502345328", "hasd12f1@gmail.com"));
//        dataPerson.getModelsList().add(new Person(7, 1, Role.Student, "Oksana", "sdggagas", "0991234567", "dwertsddf@gmail.com"));
//        dataPerson.getModelsList().add(new Person(8, 1, Role.Student, "Roman", "bvnc", "0502345678", "yasdfwer@gmail.com"));
//        dataPerson.getModelsList().add(new Person(9, 1, Role.Student, "Nataliya", "lkjhg", "0502345328", "basd12f1yutr@gmail.com"));
//        dataPerson.getModelsList().add(new Person(10, 1, Role.Student, "Olena", "sdggagas", "0991234567", "vwert233@gmail.com"));
//        dataPerson.getModelsList().add(new Person(11, 1, Role.Student, "Boris", "lkjhg", "0502345328", "zasd12f45@gmail.com"));
//        dataPerson.getModelsList().add(new Person(12, 1, Role.Student, "Misha", "lkjhg", "0502345328", "masd12f67@gmail.com"));
//        dataPerson.getModelsList().add(new Person(13, 1, Role.Student, "Jana", "lkjhg", "0502345328", "iasd12f9887@gmail.com"));
//
//        RepositoryAddMaterial addMaterial = RepositoryAddMaterial.getInstance();
//        addMaterial.getModelsList().add(new AddMaterial(3, "quadratic equations", 1, ResourceType.BOOK));
//        addMaterial.getModelsList().add(new AddMaterial(2, " equations", 3, ResourceType.URL));
//        addMaterial.getModelsList().add(new AddMaterial(1, "quadratic equations 2", 2, ResourceType.VIDEO));
//        addMaterial.getModelsList().add(new AddMaterial(1, "agssfs", 2, ResourceType.VIDEO));
//        addMaterial.getModelsList().add(new AddMaterial(2, " aequations", 3, ResourceType.URL));
//        LogCreateObject.logInfo(Main.class.getName(), LogLevel.INFO.name(), "Внесення початкових даних ", LocalDateTime.now());
//
//        GlobalMenu glMenu = new GlobalMenu();
//       glMenu.globalMenu(repositoryLecture, dataPerson, tempHomeWork, addMaterial, dataCourse);
//

    }

}
