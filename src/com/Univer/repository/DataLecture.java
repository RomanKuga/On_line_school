package com.Univer.repository;

import com.Univer.models.Lecture;

public class DataLecture extends DataMaster {
    private int size = 10;

    private Lecture[] lectureArray;
    private Lecture[] lectArrayTemp;
    private int number;

    public DataLecture() {
        this.lectureArray = new Lecture[size];

    }

    public void add(Lecture lecture) {

        super.add(lecture, lectureArray);
    }

    public Lecture[] getLectures() {
        size = super.lengthArray();
        DataLecture wers = new DataLecture();
        return (Lecture[]) super.getAll();
    }

    public Lecture[] getByld(int number) {

        return new Lecture[]{lectureArray[number - 1]};
    }

    public Lecture[] deleteByld(int number) {

        return new Lecture[]{lectureArray[number - 1]=null};

    }
}

