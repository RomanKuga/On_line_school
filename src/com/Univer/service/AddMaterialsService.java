package com.Univer.service;

public class AddMaterialsService {
    private static int calc;
    private static long id;
    public AddMaterialsService() {
        calc++;
    }

    public static int getCalcAddMaterialsService() {
        return calc;
    }

    public static long getIdAddMaterialsService() {
        return id;
    }
}
