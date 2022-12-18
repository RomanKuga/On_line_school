package com.Univer.repository;

import com.Univer.models.MasterModels;

import java.util.Arrays;

public abstract class DataMaster {
private static MasterModels[] myArray;
private MasterModels[] myArrayTemp;
private MasterModels[] newArray;
private int size;
    public void add(MasterModels masterModels, MasterModels[] myArray) {

       for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == null) {
                myArray[i] = masterModels;
                break;
            } else if (myArray[i] != null && i == myArray.length - 1) {
                myArrayTemp = myArray;
                myArray = new MasterModels[myArray.length*3/2+1];
                System.arraycopy(myArrayTemp,0,myArray,0,myArrayTemp.length);//change capacity of array
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
