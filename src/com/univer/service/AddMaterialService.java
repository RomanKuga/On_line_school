package com.univer.service;

import com.univer.errorMenuService.ErrorTestNumber;
import com.univer.models.AddMaterial;
import com.univer.models.MasterModels;
import com.univer.models.ResourceType;
import com.univer.repository.RepositoryAddMaterial;

import java.util.List;
import java.util.Scanner;

public class AddMaterialService {
    private RepositoryAddMaterial addMaterial;

    public void printArray(List<MasterModels> pers) {
        System.out.println(pers);
    }

    public void menuAddMaterials(RepositoryAddMaterial addMaterial) {
        this.addMaterial = addMaterial;
        AddMaterial addMaterialExample = new AddMaterial();
        int numberNext = 1;
        while (numberNext < 2) {

            System.out.println("1. Добавити додаткові матеріали");
            System.out.println("2. Відкрити вибрані додаткові матеріали");
            System.out.println("3. Видалити вибрані додаткові матеріали");
            System.out.println("4. Вивести список додаткових матеріалів на екран");
            System.out.println("5. Вивести список додаткових матеріалів на екран ,без елементів масива із значенням null ");
            System.out.println("6. Повернутись в основне меню");
            ErrorTestNumber testing = new ErrorTestNumber();
            int numberPers = testing.testInt();
            AddMaterialService pt = new AddMaterialService();

            switch (numberPers) {
                case 1:
                    pt.addMaterialsServiceAdd(addMaterial);
                    break;
                case 2:
                    System.out.println("Ви вибрали відкрити персони, кількість персон-" + addMaterialExample.getCalc() +
                            " / ведіть номер персони від 0 до " + (addMaterialExample.getCalc() - 1));
                    numberPers = testing.testInt();
                    System.out.println(addMaterial.getModelsList().get(numberPers));
                    break;
                case 3:
                    System.out.println("Ви вибрали видалити персону, кількість персон-" + addMaterialExample.getCalc() +
                            " / ведіть номер персони від 0 до " + (addMaterialExample.getCalc() - 1));
                    numberPers = testing.testInt();
                    this.addMaterial.getModelsList().remove(numberPers);
                    pt.printArray(this.addMaterial.getModelsList());
                    break;
                case 4:
                    pt.printArray(this.addMaterial.getModelsList());
                    break;
                case 5:
                    pt.printArray(this.addMaterial.findAll());
                    break;
                case 6:
                    numberNext = 2;
                    break;
                default:
                    System.out.println("Такої категорії не існує");
            }
        }
    }

    public void addMaterialsServiceAdd(RepositoryAddMaterial addMaterial) {
        this.addMaterial = addMaterial;
        int arrayNumber = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Добавити додаткові матеріали -                         1 
                Добавити додаткові матеріали вказавши місце в масиві - 2""");
        System.out.println("Розмір масива додаткові матеріали " + addMaterial.getModelsList().size());
        ErrorTestNumber testing = new ErrorTestNumber();
        int numberAdd = testing.testInt();
        ServiceValidator test = new ServiceValidator();
        if ((test.validatorNumber(numberAdd)) && (numberAdd == 2)) {
            System.out.println("Введіть номер в масиві");
            arrayNumber = testing.testInt();
        }
        System.out.println("Введіть ID додаткових матеріалів");
        int addMaterialNumber = testing.testInt();
        System.out.println("Введіть назву додаткових матеріалів");
        String name = scanner.next();
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
                case 0 -> {
                    resourceType = ResourceType.URL;
                    temp = 2;
                }
                case 1 -> {
                    resourceType = ResourceType.VIDEO;
                    temp = 2;
                }
                case 2 -> {
                    resourceType = ResourceType.BOOK;
                    temp = 2;
                }
                default -> {
                    System.out.println("Такої категорії не існує");
                    temp = 1;
                }
            }
        }
        if (numberAdd == 2) {
            addMaterial.getModelsList().add(arrayNumber, new AddMaterial(addMaterialNumber, name, lectureNumber, resourceType));
        }

        addMaterial.getModelsList().add(new AddMaterial(addMaterialNumber, name, lectureNumber, resourceType));
    }

}
