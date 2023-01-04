package com.Univer.repository;

import com.Univer.models.Lecture;
import com.Univer.models.MasterModels;
public class DataLecture extends DataMaster {
    private MasterModels[] lectureArray;
    public DataLecture() {
         super.DataMaster();
    }

    public void add(Lecture lecture) {
        super.elementToAdd(lecture);
    }
    public Lecture[] getLectures() {
         this.lectureArray=new Lecture[lengthArray()];
        for (int i=0; i<lengthArray(); i++){
         lectureArray[i] = (Lecture) super.getAll()[i];}
        return (Lecture[]) lectureArray;
    }

    @Override
    public void getByld(int number) {
        super.getByld(number);

    }

    @Override
    public void deleteByld(int number) {
        super.deleteByld(number);
    }
}

