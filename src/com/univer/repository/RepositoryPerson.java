package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.List;

public class RepositoryPerson extends RepositoryMaster {
    private static RepositoryPerson INSTANCE;
    private RepositoryPerson() {
        super.interfaceRepository();
    }
    public static RepositoryPerson getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryPerson();
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