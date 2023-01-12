package com.univer.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServiceValidator {
    public boolean validatorEmail(String email) {
        if (email == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatorPhone(String phone) {
        if (phone.contains("[a-zA-Z]")) {
            return false;
        }
        if (phone.length() == 10) {
            return phone.matches("\\d{10}");
        }
        return false;
    }
}
