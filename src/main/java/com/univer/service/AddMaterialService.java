package com.univer.service;

import com.univer.errorMenuService.ValidationUtil;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.MasterModels;
import com.univer.models.ResourceType;
import com.univer.repository.RepositoryAddMaterial;
import com.univer.workBaseSQL.BaseRequestAddMaterial;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class AddMaterialService {
    private RepositoryAddMaterial addMaterial;
    private static int numberTestComperble;

    public void printArray(List<MasterModels> pers) throws IOException {
        System.out.println(pers);
        LogCreateObject.logDebug(this.getClass().getName(), LogLevel.DEBUG.name(), "Вивід списку на екран ", LocalDateTime.now());
    }

    public void printTreeSet(TreeSet<MasterModels> addMaterial) throws IOException {
        System.out.println(addMaterial);
        LogCreateObject.logDebug(this.getClass().getName(), LogLevel.DEBUG.name(), "Вивід списку на екран ", LocalDateTime.now());
    }

    public void menuAddMaterials(RepositoryAddMaterial addMaterial) throws IOException {
        this.addMaterial = addMaterial;

        int numberNext = 1;
        while (numberNext < 2) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Перехід до меню Додаткові матеріали ", LocalDateTime.now());
            System.out.println("1. Добавити додаткові матеріали");
            System.out.println("2. Відкрити вибрані додаткові матеріали");
            System.out.println("3. Видалити вибрані додаткові матеріали");
            System.out.println("4. Вивести список додаткових матеріалів на екран відсортованих за лекціями");
            System.out.println("5. Вивести список додаткових матеріалів на екран ,без елементів масива із значенням null ");
            System.out.println("6. Відсортувати додаткові матеріали");
            System.out.println("7. Виберіть LEVEL для запису логів у файл");
            System.out.println("8. Повернутись в основне меню");
            ValidationUtil testing = new ValidationUtil();
            int numberPers = testing.testInt();
            AddMaterialService pt = new AddMaterialService();
            BaseRequestAddMaterial request = new BaseRequestAddMaterial();
            switch (numberPers) {
                case 1:
                    pt.addMaterialsServiceAdd(addMaterial);
                    break;
                case 2:
                    try {
                        request.openBaseAddMaterialPrintLine();
                    } catch (SQLException e) {
                        System.out.println("Помилка запиту до бази");
                    }
                    break;
                case 3:
                    try {
                        request.deleteBaseAddMaterialPrintLine();
                    } catch (SQLException e) {
                        System.out.println("Помилка запиту до бази");
                    }
                    break;
                case 4:
                    try {
                        request.sortBaseAddMaterialForLecture();
                    } catch (SQLException e) {
                        System.out.println("Помилка запиту до бази");
                    }
                    break;
                case 5:
                    try {
                        request.baseAddMaterialPrintAll();
                    } catch (SQLException e) {
                        System.out.println("Помилка запиту до бази");
                    }
                    break;
                case 6:
                    int numberSort = 1;
                    while (numberSort < 2) {

                        System.out.println("1. Сортувати за ідентифікатором додаткові матеріали");
                        System.out.println("2. Сортувати за номером лекцій додаткові матеріали");
                        System.out.println("3. Сортувати за видом додаткові матеріали");
                        numberTestComperble = testing.testInt();

                        switch (numberTestComperble) {
                            case 1:
                                try {
                                    request.sortBaseAddMaterialForID();
                                    numberSort = 2;
                                } catch (SQLException e) {
                                    System.out.println("Помилка запиту до бази");
                                }
                                break;
                            case 2:
                                try {
                                    request.sortBaseAddMaterialForLecture();
                                    numberSort = 2;
                                } catch (SQLException e) {
                                    System.out.println("Помилка запиту до бази");
                                }
                                break;
                            case 3:
                                try {
                                    request.sortBaseAddMaterialForResourseType();
                                    numberSort = 2;
                                } catch (SQLException e) {
                                    System.out.println("Помилка запиту до бази");
                                }
                                break;
                            default:
                                System.out.println("Ви помилились при виборі номера");
                                break;
                        }
                    }
                    break;
                case 7:
                    new AdjustmentLogFile().menuAdjustmentLogFile();

                    break;
                case 8:
                    numberNext = 2;
                    break;
                default:
                    System.out.println("Такої категорії не існує");
            }
        }
    }

    public int getNumberTestComperble() {
        return numberTestComperble;
    }

    public void addMaterialsServiceAdd(RepositoryAddMaterial addMaterial) throws IOException {
        this.addMaterial = addMaterial;

        Scanner scanner = new Scanner(System.in);
        ValidationUtil testing = new ValidationUtil();
        System.out.println("Введіть ID додаткових матеріалів");
        int addMaterialNumber = testing.testInt();
        System.out.println("Введіть назву додаткових матеріалів");
        String name = scanner.nextLine();
        System.out.println("Введіть ID лекції");
        int lectureNumber = testing.testInt();
        System.out.println("""
                Ведіть тип додаткових матеріалів:
                URL   - 0
                VIDEO - 1
                BOOK  - 2""");
        int temp = 1;
        ResourceType resourceType = ResourceType.URL;
        while (temp == 1) {

            int resourceNumber = testing.testInt();

            switch (resourceNumber) {
                case 0 -> temp = 2;

                case 1 -> {
                    resourceType = ResourceType.VIDEO;
                    temp = 2;
                }
                case 2 -> {
                    resourceType = ResourceType.BOOK;
                    temp = 2;
                }
                default -> System.out.println("Такої категорії не існує");

            }
        }
        try {

            BaseRequestAddMaterial request = new BaseRequestAddMaterial();
            request.addBaseAddMaterialForLecture(addMaterialNumber, name, lectureNumber, resourceType.name());
        } catch (SQLException e) {
            System.out.println("Помилка запиту до бази");

        }

    }
}
