package com.Univer.repository;

import com.Univer.models.MasterModels;

public abstract class DataMaster {
private MasterModels[] newArray;

    public void elementToAdd(MasterModels masterModels, MasterModels[] myArray) {
       for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == null) {
                myArray[i] = masterModels;
                break;
            }
        }
       newArray = myArray;
    }
      public MasterModels[] getAll() {
        return newArray;
    }
    public int lengthArray(){
        return newArray.length;
    }
}
