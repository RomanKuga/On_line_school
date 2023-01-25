package com.univer.repository;

import com.univer.models.MasterModels;
import com.univer.models.Person;
import com.univer.utilities.Simpleiterator;

public class RepositoryPerson extends RepositoryMaster {

    private Person[] personArray;


    public RepositoryPerson() {
        super.interfaceRepository();
    }

    @Override
    public MasterModels get(int index) {
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

//    @Override
//    public Person[] findAll() {
//        this.personArrayTmp = new Person[super.findAll().length];
//        personArrayTmp= (Person[]) super.findAll();
//        return personArrayTmp;
//    }

    public Person[] findAll() {
            Simpleiterator iterator = new Simpleiterator(getPerson());
            while (iterator.hesNext()){
                if (iterator.next()==null){
                    iterator.remove();
                }
            }
        this.personArray = new Person[iterator.getModel().length];
        for (int i = 0; i < iterator.getModel().length; i++) {
            personArray[i] = (Person) iterator.getModel()[i];
        }
        return  personArray;
    }
}