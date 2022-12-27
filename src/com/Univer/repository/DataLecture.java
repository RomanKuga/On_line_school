package com.Univer.repository;

import com.Univer.models.Lecture;

public class DataLecture extends DataMaster {
    private  static int size =10;
    private int number;

    private final Lecture[] lectureArray;

    public DataLecture() {
       this.lectureArray = new Lecture[size];
    }

    public void add(Lecture lecture) {

        super.elementToAdd(lecture, lectureArray);
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

