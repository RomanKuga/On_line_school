package com.univer.service;

import com.univer.errorMenuService.ValidationUtil;
import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceValidator {
    public boolean validatorEmail(String email) throws IOException {
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.DEBUG.name(), "Провірка валідності Email ", LocalDateTime.now());
        if (email == null) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.ERROR.name(), "Помилка введення Email ", LocalDateTime.now());
            return false;
        }
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatorPhone(String phone) throws IOException {
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.DEBUG.name(), "Провірка валідності номера телефона ", LocalDateTime.now());
        if (phone.contains("[a-zA-Z]")) {
            LogCreateObject.logInfo(this.getClass().getName(), LogLevel.ERROR.name(), "Помилка номера телефона ", LocalDateTime.now());
            return false;
        }
        if (phone.length() == 10) {
            return phone.matches("\\d{10}");
        }
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.ERROR.name(), "Помилка номера телефона ", LocalDateTime.now());
        return false;
    }

    public int validatorNumber() throws IOException {
        int number = new ValidationUtil().testInt();
        boolean control = false;
        while (!control) {

            if ((number != 1) && (number!=2)) {
                System.out.println("Ви ввели невірний номер спробуйте знову ");
                number = new ValidationUtil().testInt();
            } else { control=true;}
        }
        return number;
    }
    public boolean validatorIP(String adressIP){
        String formIPchapter = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        String formAllIP= formIPchapter+"\\."+formIPchapter+"\\."+formIPchapter+"\\."+formIPchapter;
        if ((adressIP==null)||(adressIP.contains("[a-zA-Z]"))){
            System.out.println("IP адрес введений неправильно спробуте знов");
            return false;
        }
        Pattern pattern = Pattern.compile(formAllIP);
        Matcher matcher = pattern.matcher(adressIP);
        return matcher.matches();

    }
}
