package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.List;

public class RepositoryHomeWork extends RepositoryMaster {
    private static RepositoryHomeWork INSTANCE;

    private   RepositoryHomeWork() {
        super.interfaceRepository();
    }
    public static RepositoryHomeWork getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryHomeWork();

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
