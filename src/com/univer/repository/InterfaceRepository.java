package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.List;

public interface InterfaceRepository<T extends MasterModels> {
//
//    void add(int index, T masterModels);
//
//    void add(T masterModels);
//
    void interfaceRepository();

    List<MasterModels> findAll();
//
//    T get(int index);
//
//    int size();
//
//    void remove(int number);
//
//    boolean isEmpty();
//
//     T[] findAll() ;

}
