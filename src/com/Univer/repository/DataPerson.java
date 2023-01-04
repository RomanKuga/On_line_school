package com.Univer.repository;

import com.Univer.models.Lecture;
import com.Univer.models.MasterModels;
import com.Univer.models.Person;

public class DataPerson extends DataMaster{
    private  static int size =5;
    private int number;

    private  Person[] personArray;
    public DataPerson() {
        this.personArray = new Person[size];
    }
    public void personToAdd(Person person) {
        if (personArray[personArray.length - 1] != null){
            Person[] myArrayTemp = personArray;
            personArray = new Person[personArray.length*3/2+1];
            System.arraycopy(myArrayTemp,0,personArray,0,myArrayTemp.length);
        super.elementToAdd(person, personArray);
        } else {
            super.elementToAdd(person,personArray);
        }
    }
    public Person[] getPerson() {
        return (Person[])  super.getAll();
    }
    public Person[] getByldPerson(int number) {
        return new Person[]{ personArray [number - 1]};
    }
    public void deleteByldPerson(int number) {
        this.number=number;
        personArray[number - 1]=null;

    }
}
