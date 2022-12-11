package com.Univer.service;
import com.Univer.models.Lecture;
import com.Univer.repository.DataLecture;
import java.util.Arrays;
public class LecturesService {
    public static int calc;
    private static long id;
    private DataLecture temp;
    public void printArray(Lecture[] lect) {

        System.out.println(Arrays.toString(lect));
    }

}
