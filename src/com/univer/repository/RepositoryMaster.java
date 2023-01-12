package com.univer.repository;

import com.univer.models.MasterModels;

public abstract class RepositoryMaster<T> {
    private T[] newArray;
    private static int size = 5;
    private T[] myArray;
    private int number;
    private int index;
    private T[] myArrayTemp;

    public void DataMaster() {
        this.myArray = (T[]) new MasterModels[size];
    }

    public void elementToAdd(T masterModels) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == null) {
                myArray[i] = (T) masterModels;
                break;
            } else if (myArray[i] != null && i == myArray.length - 1) {
                myArrayTemp = (T[]) myArray;
                myArray = (T[]) new Object[myArray.length * 3 / 2 + 1];
                System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);//change capacity of array
            }

        }
        newArray = (T[]) myArray;
    }

    public T[] getAll() {
        return newArray;
    }

    public void getByld(int number) {
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
