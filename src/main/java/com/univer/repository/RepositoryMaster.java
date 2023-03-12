package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RepositoryMaster implements InterfaceRepository<MasterModels> {
    private List<MasterModels> modelsList;

    @Override
    public void interfaceRepository() {
        this.modelsList = new ArrayList<>();
    }

    public List<MasterModels> getModelsList() {
        return modelsList;
    }

    @Override
    public List<MasterModels> findAll() {
        Iterator<MasterModels> iterator = modelsList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == null) {
                iterator.remove();
            }
        }
        return modelsList;

    }

}
