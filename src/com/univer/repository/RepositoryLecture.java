package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.List;

public  class RepositoryLecture extends RepositoryMaster {
    private static RepositoryLecture INSTANCE;
    private RepositoryLecture() {
         super.interfaceRepository();
    }
    public static RepositoryLecture getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryLecture();

        }
        return INSTANCE;
    }
    @Override
    public List<MasterModels> getModelsList() {
        return super.getModelsList();
    }

    @Override
    public List<MasterModels> findAll() {
        return super.findAll();
    }

}

