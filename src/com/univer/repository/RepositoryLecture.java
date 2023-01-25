package com.univer.repository;

import com.univer.models.Lecture;
import com.univer.models.MasterModels;
import com.univer.utilities.Simpleiterator;

public  class RepositoryLecture extends RepositoryMaster {
    private Lecture[] lectureArray;
    public RepositoryLecture() {
         super.interfaceRepository();
    }

    @Override
    public Lecture get(int index) {
        return (Lecture) super.get(index);
    }


    @Override
    public void add(int index, MasterModels masterModels) {
        super.add(index, masterModels);
    }

    @Override
    public void add(MasterModels masterModels) {
        super.add(masterModels);
    }

    @Override
    public int size() {
        return super.size();
    }

    public Lecture[] getLectures() {
         this.lectureArray=new Lecture[size()];
        for (int i=0; i<size(); i++){
         lectureArray[i] = (Lecture) super.get(i);}
        return  lectureArray;
    }

    public Lecture[] findAll() {
        Simpleiterator iterator = new Simpleiterator(getLectures());
        while (iterator.hesNext()){
            if (iterator.next()==null){
                iterator.remove();
            }
        }
        this.lectureArray = new Lecture[iterator.getModel().length];
        for (int i = 0; i < iterator.getModel().length; i++) {
            lectureArray[i] = (Lecture) iterator.getModel()[i];
        }
        return  lectureArray;
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

