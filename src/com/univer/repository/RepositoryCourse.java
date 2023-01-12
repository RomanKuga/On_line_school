package com.univer.repository;

public class RepositoryCourse extends RepositoryMaster {
    private  static int sizeDataCourse =5;
    private int[] arrayCourse = {1, 2, 3, 4, 5};

    public static int getSizeDataCourse() {
        return sizeDataCourse;
    }

    public int[] getArrayCourse() {
        return arrayCourse;
    }
}
