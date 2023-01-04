package com.Univer.service;
import com.Univer.models.Lecture;
import com.Univer.models.MasterModels;
import com.Univer.repository.DataLecture;

import java.util.Arrays;
import java.util.Scanner;

public class LecturesService {
    private static int calc;
    private static long id;
private DataLecture dataLecture;
    public void printArray(MasterModels[] lect) {

        System.out.println(Arrays.toString(lect));
    }
     public void menuLecrute(DataLecture dataMaster){
        this.dataLecture=dataMaster;
        Lecture lectureExample = new Lecture();
        int numberNext = 1;
         while (numberNext < 2) {

             System.out.println("1. Добавити лекцію");
             System.out.println("2. Відкрити вибрану лекцію");
             System.out.println("3. Видалити вибрану лекцію");
             System.out.println("4. Вивести лекції на екран");
             System.out.println("5. Повернутись в основне меню");

             Scanner scanner = new Scanner(System.in);
             int numberLect = scanner.nextInt();
             LecturesService pt = new LecturesService();

             switch (numberLect) {
                 case 1:
                     if (lectureExample.getID() < 8) {
                         System.out.println("Введіть ID курсу");
                         int courseNumber = scanner.nextInt();
                         System.out.println("Введіть назву лекції");
                         String nameLecture = scanner.next();
                         System.out.println("Введіть ID лекції");
                         int lectureId = scanner.nextInt();
                         System.out.println("Введіть ID викладача із списку");

                         int personID = scanner.nextInt();

                         dataLecture.add(new Lecture(lectureId, courseNumber, nameLecture,personID));
                         break;
                     } else {
                         System.out.println("Кількість лекцій перевищує 8 ");
                         numberNext = 2;
                         break;
                     }
                 case 2:
                     System.out.println("Ви вибрали відкрити лекцію, кількість лекцій-"+lectureExample.getCalcLecture()+
                             " / ведіть номер лекції від 1 до "+lectureExample.getCalcLecture());
                     numberLect = scanner.nextInt();
                     dataLecture.getByld(numberLect);
                     break;
                 case 3:
                     System.out.println("Ви вибрали видалити лекцію, кількість лекцій-"+lectureExample.getCalcLecture()+
                             " / ведіть номер лекції від 1 до "+lectureExample.getCalcLecture());
                     numberLect = scanner.nextInt();
                     dataLecture.deleteByld(numberLect);
                     pt.printArray(dataLecture.getLectures());
                     break;
                 case 4:
                     pt.printArray(dataLecture.getLectures());
                     break;
                 case 5:
                     numberNext = 2;
                     break;
                 default :
                     System.out.println("Такої категорії не існує");
             }
         }
     }
    public static int getCalcLecturesService() {
        return calc;
    }
    public static long getIdLecturesService() {
        return id;
    }
}
