package com.univer.repository;

import com.univer.models.MasterModels;
import com.univer.models.Person;

public class RepositoryPerson extends RepositoryMaster {

    private Person[] personArray;


    public RepositoryPerson() {
        super.interfaceRepository();
    }

    @Override
    public Person get(int index) {
        return (Person) super.get(index);
    }

    @Override
    public void add(int index, MasterModels masterModels) {
        super.add(index, masterModels);
    }

    @Override
    public void add(MasterModels masterModels) {
        super.add(masterModels);
    }

    public Person[] getPerson() {
        this.personArray = new Person[size()];
        for (int i = 0; i < size(); i++) {
            personArray[i] = (Person) super.get(i);
        }
        return  personArray;
    }

    @Override
    public void getByld(int number) {
        super.getByld(number);
    }

    @Override
    public int getIndex() {
        return super.getIndex();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public void remove(int number) {
        super.remove(number);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }
}