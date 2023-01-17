package com.univer.repository;

import com.univer.models.MasterModels;

public interface InterfaceRepository<T extends MasterModels> {

    void add(int index, T masterModels);

    void add(T masterModels);

    void InterfaceRepository();

    T get(int index);

    int size();

    void remove(int number);

    boolean isEmpty();

}
