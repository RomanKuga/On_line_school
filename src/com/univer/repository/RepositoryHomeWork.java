package com.univer.repository;

import com.univer.models.HomeWork;
import com.univer.models.MasterModels;

public class RepositoryHomeWork extends RepositoryMaster {
    private static RepositoryHomeWork INSTANCE;
    private HomeWork[] homeWorkArray;

    public  RepositoryHomeWork() {
        super.interfaceRepository();
    }
    public static RepositoryHomeWork getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryHomeWork();

        }
        return INSTANCE;
    }
    public HomeWork[] getHomeWorkArray() {
        this.homeWorkArray=new HomeWork[size()];
        for (int i=0; i<size(); i++){
            homeWorkArray[i] = (HomeWork) super.get(i);}
        return  homeWorkArray;
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
    public HomeWork get(int index) {
        return (HomeWork) super.get(index);
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
