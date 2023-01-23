package com.univer.models;

public abstract class MasterModels {
    private Integer ID;

    public MasterModels(Integer ID) {
        this.ID = ID;
    }

    public MasterModels() {
    }



    public int getID() {
        return ID;
    }


}
