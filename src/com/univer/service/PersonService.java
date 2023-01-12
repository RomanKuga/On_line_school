package com.univer.service;

import com.univer.models.Person;
import com.univer.models.Role;
import com.univer.repository.RepositoryPerson;

import java.util.Arrays;
import java.util.Scanner;

public class PersonService {
    private RepositoryPerson dataPerson;

    public void printArray(Person[] pers) {

        System.out.println(Arrays.toString(pers));
    }

    public void menuPerson(RepositoryPerson dataPerson) {
        this.dataPerson = dataPerson;
        Person personExample = new Person();
        int numberNext = 1;
        while (numberNext < 2) {

            System.out.println("1. Добавити персону");
            System.out.println("2. Відкрити вибрану персону");
            System.out.println("3. Видалити вибрану персону");
            System.out.println("4. Вивести список персон на екран");
            System.out.println("5. Повернутись в основне меню");

            Scanner scanner = new Scanner(System.in);
            int numberPers = scanner.nextInt();
            PersonService pt = new PersonService();

            switch (numberPers) {
                case 1:
                    System.out.println("Введіть ID персони");
                    int personNumber = scanner.nextInt();
                    System.out.println("Введіть ID курсу");
                    int courseNumber = scanner.nextInt();
                    System.out.println("Введіть ім'я персони");
                    String firstName = scanner.next();
                    System.out.println("Введіть прізвище персони");
                    String secondName = scanner.next();
                    System.out.println("Ведіть: 0 - Студент або 1 - Викладач");
                    int roleNumber = scanner.nextInt();
                    Role role = Role.Teacher;
                    if (roleNumber == 0) {
                        role = Role.Student;
                    }

                    System.out.println("Введіть мобільний телефон персони, у форматі 0ххххххххх без коду країни");
                    String phone = scanner.next();
                    boolean phoneControl = false;
                    while (!phoneControl) {
                        ServiceValidator test = new ServiceValidator();
                        test.validatorPhone(phone);
                        if (test.validatorPhone(phone) == false) {
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
                        ServiceValidator test = new ServiceValidator();
                        test.validatorEmail(email);
                        if (test.validatorEmail(email) == false) {
                            System.out.println("Ви ввели не вірний email, повторіть знову:");
                            email = scanner.next();
                        } else {
                            mailControl = true;
                        }
                    }

                    dataPerson.personToAdd(new Person(personNumber, courseNumber, role, firstName, secondName, phone, email));
                    break;
                case 2:
                    System.out.println("Ви вибрали відкрити персони, кількість персон-" + personExample.getCalcPerson() +
                            " / ведіть номер лекції від 1 до " + personExample.getCalcPerson());
                    numberPers = scanner.nextInt();
//                    dataPerson.getByld(numberPers);
                    break;
                case 3:
                    System.out.println("Ви вибрали видалити персону, кількість персон-" + personExample.getCalcPerson() +
                            " / ведіть номер лекції від 1 до " + personExample.getCalcPerson());
                    numberPers = scanner.nextInt();
//                    this.dataPerson.deleteByld(numberPers);
//                    pt.printArray(this.dataPerson.getPerson());
                    break;
                case 4:
//                    pt.printArray(this.dataPerson.getPerson());
                    break;
                case 5:
                    numberNext = 2;
                    break;
                default:
                    System.out.println("Такої категорії не існує");
            }
        }
    }
}
