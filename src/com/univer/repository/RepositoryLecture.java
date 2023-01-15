package com.univer.repository;

import com.univer.models.Lecture;
public class RepositoryLecture extends RepositoryMaster<Lecture> {
    private Lecture[] lectureArray;
    public RepositoryLecture() {
         super.repositoryMaster();
    }

    @Override
    public Lecture get(int index) {
        return super.get(index);
    }

    @Override
    public void add(Lecture lecture) {
        super.add(lecture);
    }

    @Override
    public void add(int index, Lecture masterModels) {
        super.add(index, masterModels);
    }

    public Lecture[] getLectures() {
         this.lectureArray=new Lecture[size()];
        for (int i=0; i<size(); i++){
         lectureArray[i] =  super.get(i);}
        return  lectureArray;
    }

    @Override
    public void getByld(int number) {
        super.getByld(number);

    }

    @Override
    public void remove(int number) {
        super.remove(number);
    }

    @Override
    public int getIndex() {
        return super.getIndex();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}

