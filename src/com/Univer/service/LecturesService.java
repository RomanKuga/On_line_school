package com.Univer.service;
import com.Univer.models.Lecture;
import com.Univer.repository.DataLecture;
import java.util.Arrays;
public class LecturesService {
    private static int calc;
    private static long id;

    public void printArray(Lecture[] lect) {

        System.out.println(Arrays.toString(lect));
    }

    public static int getCalcLecturesService() {

        return calc;
    }

    public static long getIdLecturesService() {

        return id;
    }
}
