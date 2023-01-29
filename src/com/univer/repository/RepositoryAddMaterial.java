package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.List;

public class RepositoryAddMaterial extends RepositoryMaster{
    private static RepositoryAddMaterial INSTANCE;

    public  RepositoryAddMaterial() {
        super.interfaceRepository();
    }

    @Override
    public List<MasterModels> getModelsList() {
        return super.getModelsList();
    }

    @Override
    public List<MasterModels> findAll() {
        return super.findAll();
    }
    public static RepositoryAddMaterial getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryAddMaterial();

        }
        return INSTANCE;
    }
}
