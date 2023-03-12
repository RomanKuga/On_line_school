package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.List;

public  class RepositoryCourse extends RepositoryMaster {

    private static RepositoryCourse INSTANCE;

    private RepositoryCourse (){

        super.interfaceRepository();
    }

    public List<MasterModels> getCourseList() {
        return super.getModelsList();
    }

    @Override
    public List<MasterModels> findAll() {
        return super.findAll();
    }
    public static RepositoryCourse getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryCourse();
        }
        return INSTANCE;
    }

}
