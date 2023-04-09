package com.univer.repository;

import com.univer.models.MasterModels;
import org.springframework.stereotype.Component;

import java.util.List;
@Component()
public  class RepositoryCourse extends RepositoryMaster {

    private  RepositoryCourse INSTANCE;

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

    public  RepositoryCourse getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryCourse();
        }
        return INSTANCE;
    }

}
