package com.univer.repository;

import com.univer.models.Person;

public class RepositoryPerson extends RepositoryMaster {

    private  Person[] personArray;
    public RepositoryPerson() {
         super.DataMaster();
    }
    public void personToAdd(Person person) {
        super.elementToAdd(person);
    }
    public Person[] getPerson() {
        this.personArray=new Person[lengthArray()];
        for (int i=0; i<lengthArray(); i++){
            personArray[i] = (Person) super.getAll()[i];}
        return (Person[]) personArray;
    }
    @Override
    public void getByld(int number) {
        super.getByld(number);

    }

    @Override
    public void deleteByld(int number) {
        super.deleteByld(number);
    }

    @Override
    public int getIndex() {
        return super.getIndex();
    }
}
