package com.univer.models;

public abstract class MasterModels {
    private Integer ID;

    protected MasterModels(Integer ID) {
        this.ID = ID;
    }

    public MasterModels() {
    }



    public int getID() {
        return ID;
    }


    public abstract Integer getLectureId();
}
