package com.univer.repository;

import com.univer.models.Person;

public class RepositoryPerson extends RepositoryMaster<Person> {

    private Person[] personArray;


    public RepositoryPerson() {
        super.repositoryMaster();
    }

    @Override
    public Person get(int index) {
        return super.get(index);
    }

    @Override
    public void add(Person person) {
        super.add(person);
    }

    @Override
    public void add(int index, Person masterModels) {
        super.add(index, masterModels);
    }

    public Person[] getPerson() {
        this.personArray = new Person[size()];
        for (int i = 0; i < size(); i++) {
            personArray[i] = super.get(i);
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

}