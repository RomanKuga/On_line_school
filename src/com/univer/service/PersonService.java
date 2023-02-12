package com.univer.service;

import com.univer.errorMenuService.ErrorTestNumber;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.MasterModels;
import com.univer.models.Person;
import com.univer.models.Role;
import com.univer.repository.RepositoryPerson;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class PersonService {
    private RepositoryPerson dataPerson;

    public void printArray(List<MasterModels> pers) {
        System.out.println(pers);
    }
    public void printTreeSet(TreeSet<MasterModels> pers) {
        System.out.println(pers);
    }

    public void menuPerson(RepositoryPerson dataPerson) throws IOException {
        this.dataPerson = dataPerson;
        Person personExample = new Person();
        int numberNext = 1;
        while (numberNext < 2) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до меню персони ", LocalDateTime.now());

            System.out.println("1. Добавити персону");
            System.out.println("2. Відкрити вибрану персону");
            System.out.println("3. Видалити вибрану персону");
            System.out.println("4. Вивести список персон на екран");
            System.out.println("5. Вивести список персон на екран ,без елементів масива із значенням null ");
            System.out.println("6. Відсортувати список за прізвищем");
            System.out.println("7. Виберіть LEVEL для запису логів у файл");
            System.out.println("8. Повернутись в основне меню");
            ErrorTestNumber testing = new ErrorTestNumber();
            int numberPers = testing.testInt();
            PersonService pt = new PersonService();

            switch (numberPers) {
                case 1:
                    pt.personServiceAdd(dataPerson);
                    break;
                case 2:
                    System.out.println("Ви вибрали відкрити персони, кількість персон-" + personExample.getCalcPerson() +
                            " / ведіть номер персони від 0 до " + (personExample.getCalcPerson()-1));
                    numberPers = testing.testInt();
                    System.out.println(dataPerson.getModelsList().get(numberPers));
                    break;
                case 3:
                    System.out.println("Ви вибрали видалити персону, кількість персон-" + personExample.getCalcPerson() +
                            " / ведіть номер персони від 0 до " + (personExample.getCalcPerson()-1));
                    numberPers = testing.testInt();
                    this.dataPerson.getModelsList().remove(numberPers);
                    pt.printArray(this.dataPerson.getModelsList());
                    break;
                case 4:
                    pt.printArray(this.dataPerson.getModelsList());
                    break;
                case 5:
                    pt.printArray( this.dataPerson.findAll());
                    break;
                case 6:
                    TreeSet<MasterModels> sortPersonList= new TreeSet<>(dataPerson.getModelsList());
                    pt.printTreeSet(sortPersonList);
                    break;
                case 7:
                    AdjustmentLogFile menuALF= new AdjustmentLogFile();
                    menuALF.AdjustmentLogFile();
                    break;
                case 8:
                    numberNext = 2;
                    break;
                default:
                    System.out.println("Такої категорії не існує");
            }
        }
    }

    public void personServiceAdd(RepositoryPerson dataPerson) throws IOException {
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід меню добавлення персони ", LocalDateTime.now());
        this.dataPerson=dataPerson;
        int arrayNumber = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                        Добавити персону -                        1 
                       Добавити персону вказавши місце в масиві - 2""");
        System.out.println("Розмір масива Персони " + dataPerson.getModelsList().size());
        ErrorTestNumber testing = new ErrorTestNumber();
        int numberPers = testing.testInt();
        ServiceValidator test = new ServiceValidator();
        if ((test.validatorNumber(numberPers)) && (numberPers ==2)) {
            System.out.println("Введіть номер в масиві");
            arrayNumber = testing.testInt();
        }
        System.out.println("Введіть ID персони");
        int personNumber = testing.testInt();
        System.out.println("Введіть ID курсу");
        int courseNumber = testing.testInt();
        System.out.println("Введіть ім'я персони");
        String firstName = scanner.next();
        System.out.println("Введіть прізвище персони");
        String secondName = scanner.next();
        System.out.println("Ведіть: 0 - Студент або 1 - Викладач");
        int roleNumber = testing.testInt();
        Role role = Role.Teacher;
        if (roleNumber == 0) {
            role = Role.Student;
        }
        System.out.println("Введіть мобільний телефон персони, у форматі 0ххххххххх без коду країни");
        String phone = scanner.next();
        boolean phoneControl = false;
        while (!phoneControl) {
            test.validatorPhone(phone);
            if (!test.validatorPhone(phone)) {
                System.out.println("Введіть мобільний телефон персони повторно, у форматі хххххххххх без коду країни");
                phone = scanner.next();
            } else {
                phoneControl = true;
            }
        }
        System.out.println("Введіть email персони");
        String email = scanner.next();
        boolean mailControl = false;
        while (!mailControl) {
            test.validatorEmail(email);
            if (!test.validatorEmail(email)) {
                System.out.println("Ви ввели не вірний email, повторіть знову:");
                email = scanner.next();
            } else {
                mailControl = true;
            }
        }
        if (numberPers==2){dataPerson.getModelsList().add(arrayNumber,new Person(personNumber, courseNumber, role, firstName, secondName, phone, email));}

        dataPerson.getModelsList().add(new Person(personNumber, courseNumber, role, firstName, secondName, phone, email));
    }

}
