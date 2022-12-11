package com.Univer.repository;

import com.Univer.models.Lecture;

import java.util.Arrays;

public class DataLecture {
    private final int size =10;

    private Lecture[] lectureArray;
    private Lecture[] lectureArrayTemp;
   // public Lecture[] lectureArrayPrint;
    private int x =5;

    public DataLecture() {
        this.lectureArray = new Lecture[size];

    }
    public void add(Lecture lecture) {

        for (int i = 0; i < lectureArray.length; i++) {
            if (lectureArray[i] == null) {
                lectureArray[i] = lecture;
                break;
            } else if (lectureArray[i] != null && i == lectureArray.length - 1) {
                lectureArrayTemp = lectureArray;
                lectureArray = new Lecture[x*3/2+1];
                System.arraycopy(lectureArrayTemp,0,lectureArray,0,lectureArrayTemp.length);//change capacity of array
            }
        }
    }
 /* public Lecture[] lectureArrayPrint = lectureArray ;
    public  Lecture[] getLectureArray(){
        return lectureArray;
}*/
 public void printArray() {
     System.out.println(Arrays.toString(lectureArray));
 }
}

