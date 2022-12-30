package com.Univer.repository;

import com.Univer.models.Lecture;
import com.Univer.models.MasterModels;
public class DataLecture extends DataMaster {
    private  static int size =5;
    private int number;
    private  static Lecture[] lectureArray;
    public DataLecture() {
       this.lectureArray = new Lecture[size];
    }
    public void add(Lecture lecture) {
        if (lectureArray[lectureArray.length - 1] != null){
            Lecture[] myArrayTemp = lectureArray;
            lectureArray = new Lecture[lectureArray.length*3/2+1];
            System.arraycopy(myArrayTemp,0,lectureArray,0,myArrayTemp.length);
            super.elementToAdd(lecture,lectureArray);
        } else {
      super.elementToAdd(lecture,lectureArray);
        }
    }
    public Lecture[] getLectures() {
        return (Lecture[]) super.getAll();
    }
    public Lecture[] getByld(int number) {
        return new Lecture[]{ lectureArray[number - 1]};
    }
    public void deleteByld(int number) {
      this.number=number;
        lectureArray[number - 1]=null;
    }
}

