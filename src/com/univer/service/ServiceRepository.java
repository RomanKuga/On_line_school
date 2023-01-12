package com.univer.service;

import com.univer.models.MasterModels;

import java.util.Arrays;

public class ServiceRepository <E>{
    private E[] newArray;
    private static int size = 5;
     private E[] myArray;
    private int number;
    private int index;
    private E[] myArrayTemp;

    public  ServiceRepository() {
        this.myArray = (E[]) new MasterModels[size];
    }

    public  void add(E masterModels) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == null) {
                myArray[i] = (E) masterModels;
                break;
            } else if (myArray[i] != null && i == myArray.length - 1) {
                myArrayTemp = (E[]) myArray;
                myArray = (E[]) new MasterModels[myArray.length * 3 / 2 + 1];
                System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);//change capacity of array
            }

        }
        newArray =  myArray;
        System.out.println(Arrays.toString(newArray));

    }

    public E[] get() {
        return newArray;
    }

    public <E> void getByld(int number) {
        this.number = number;
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] != null) {
                MasterModels wer = (MasterModels) newArray[i];
                if (wer.getID() == number) {
                    System.out.println(newArray[i]);
                    index = i;
                }
            }
        }
    }

    public int getIndex() {
        return index;
    }

    public int lengthArray() {
        return myArray.length;
    }

    public void deleteByld(int number) {
        this.number = number;
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] != null) {
                MasterModels wer = (MasterModels) newArray[i];
                if (wer.getID() == number) {
                    for (int j = i; j < newArray.length - 1; j++) {
                        newArray[j] = newArray[j + 1];
                    }
                }
            }
        }

    }

}
