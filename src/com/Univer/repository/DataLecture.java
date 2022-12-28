package com.Univer.repository;

import com.Univer.models.Lecture;
import com.Univer.models.MasterModels;

public class DataLecture extends DataMaster {
    private  static int size =5;
    private int number;

    private final Lecture[] lectureArray;

    public DataLecture() {
       this.lectureArray = new Lecture[size];
    }

    public void add(Lecture lecture) {

        super.elementToAdd(lecture, lectureArray);
    }

    public Lecture[] getLectures() {
        Lecture[] wer = new Lecture[lengthArray()];
        for (int i = 0; i < lengthArray(); i++) {
            wer[i] = (Lecture) super.getAll(i);
        }
        return wer;
    }

    public Lecture[] getByld(int number) {
        return new Lecture[]{ lectureArray[number - 1]};
    }

    public void deleteByld(int number) {
      this.number=number;
      lectureArray[number - 1]=null;
    }
}

