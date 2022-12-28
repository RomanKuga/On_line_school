package com.Univer.repository;

import com.Univer.models.MasterModels;

import java.util.Arrays;

public abstract class DataMaster {
private MasterModels[] newArray;
    public void elementToAdd(MasterModels masterModels, MasterModels[] myArray) {

       for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == null) {
                myArray[i] = masterModels;
                break;
            } else if (myArray[i] != null && i == myArray.length - 1) {
                MasterModels[] myArrayTemp = myArray;
                myArray = new MasterModels[myArray.length*3/2+1];
                System.arraycopy(myArrayTemp,0,myArray,0,myArrayTemp.length);//change capacity of array
            }

        }

       newArray = myArray;
    }

    public MasterModels getAll(int l) {

        return newArray[l];
    }

    public int lengthArray(){
        return newArray.length;
    }
}
