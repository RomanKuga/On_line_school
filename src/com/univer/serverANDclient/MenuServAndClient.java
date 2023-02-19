package com.univer.serverANDclient;

import com.univer.errorMenuService.ValidationUtil;
import com.univer.service.ServiceValidator;

import java.io.IOException;
import java.util.Scanner;

public class MenuServAndClient {
    public MenuServAndClient() throws IOException {
        int df = 1;
        while (df == 1) {
            System.out.println("""
                    Cерверно-клєнтське меню:
                     Запустити сервер             - 1
                     Запустити клієнтсервер       - 2
                     Редагувати BlackList адрес   - 3
                     """);
            ValidationUtil number = new ValidationUtil();
            switch (number.testInt()) {
                case 1 -> {
                    Thread thread = new Thread(new ServerRun());
                    thread.start();

                }
                case 2 -> {
                    Thread thread = new Thread(new ClientRun());
                    thread.start();

                }
                case 3 -> {
                    menuBlackList();

                    df = 2;
                }


                default -> System.out.println("Такої категорії не існує");
            }
        }
    }

    public void menuBlackList() throws IOException {
        int df = 1;
        Scanner scanner = new Scanner(System.in);
        ServiceValidator testIPerror = new ServiceValidator();
        while (df == 1) {
            System.out.println("""
                    BlackList меню:
                    Записати IP в BlackList   - 1
                    Видалити IP з BlackList   - 2
                    Переглянути BlackList     - 3
                    Вийти з меню BlackList    - 4
                    """);
            ValidationUtil number = new ValidationUtil();
            switch (number.testInt()) {
                case 1 -> {
                    int kf = 1;
                    while (kf == 1) {
                        System.out.println("Введіть ІР для запису");
                        String adressIP = scanner.next();
                        if (testIPerror.validatorIP(adressIP)) {
                            BlackListWriteRemove.writeBlackList(adressIP);
                            kf = 2;
                        }
                    }
                }
                case 2 -> {
                    int kf = 1;
                    while (kf == 1) {
                        System.out.println("Введіть ІР для видалення");
                        String addressIP = scanner.next();
                        if (testIPerror.validatorIP(addressIP)) {
                            BlackListWriteRemove.removeBlackList(addressIP);
                            kf = 2;
                        }
                    }
                }
                case 3 -> {
                    BlackListWriteRemove.printBlackList();

                }
                case 4 -> {

                    df = 2;
                }


                default -> System.out.println("Такої категорії не існує");
            }

        }

    }
}
