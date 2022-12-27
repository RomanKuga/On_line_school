package com.Univer.repository;

import com.Univer.models.Course;
import com.Univer.models.MasterModels;

public class DataCourse extends DataMaster{
    private  static int sizeDataCourse =5;
    private int[] arrayCourse = {1, 2, 3, 4, 5};

    public static int getSizeDataCourse() {
        return sizeDataCourse;
    }

    public int[] getArrayCourse() {
        return arrayCourse;
    }
}
