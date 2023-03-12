package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.List;

public interface InterfaceRepository<T extends MasterModels> {

    void interfaceRepository();

    List<MasterModels> findAll();

}
