package com.Univer.service;

import com.Univer.models.Role;
import com.Univer.models.Person;
import com.Univer.repository.DataPerson;

import java.util.Arrays;
import java.util.Scanner;

public class PersonService {
    private static int calc;
    private static long id;

    private DataPerson dataPerson;
    public void printArray(Person[] pers) {

        System.out.println(Arrays.toString(pers));
    }
    public void menuPerson(DataPerson dataPerson){
       this.dataPerson=dataPerson;
        Person personExample = new Person();
        boolean exitBoolean = false;
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
                        if (roleNumber==0) {
                    Role role= Role.Student;
                            dataPerson.personToAdd(new Person(personNumber, courseNumber, role, firstName,secondName));
                } else {
                    Role role= Role.Teacher;
                            dataPerson.personToAdd(new Person(personNumber, courseNumber, role, firstName,secondName));
                }
                        break;
                case 2:
                    System.out.println("Ви вибрали відкрити персони, кількість персон-"+personExample.getCalcPerson()+
                            " / ведіть номер лекції від 1 до "+personExample.getCalcPerson());
                    numberPers = scanner.nextInt();
                    dataPerson.getByld(numberPers);
                    break;
                case 3:
                    System.out.println("Ви вибрали видалити персону, кількість персон-"+personExample.getCalcPerson()+
                            " / ведіть номер лекції від 1 до "+personExample.getCalcPerson());
                    numberPers = scanner.nextInt();
                    this.dataPerson.deleteByld(numberPers);
                    pt.printArray(this.dataPerson.getPerson());
                    break;
                case 4:
                    pt.printArray(this.dataPerson.getPerson());
                    break;
                case 5:
                    numberNext = 2;
                    break;
                default :
                    System.out.println("Такої категорії не існує");
            }
        }
    }
}
