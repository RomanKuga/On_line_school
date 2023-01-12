package com.univer.repository;

import com.univer.models.Lecture;
import com.univer.models.MasterModels;
public class RepositoryLecture extends RepositoryMaster {
    private MasterModels[] lectureArray;
    public RepositoryLecture() {
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
//
//    @Override
//    public void getByld(int number) {
//        super.getByld(number);
//
//    }
//
//    @Override
//    public void deleteByld(int number) {
//        super.deleteByld(number);
//    }
//
//    @Override
//    public int getIndex() {
//        return super.getIndex();
//    }
}

