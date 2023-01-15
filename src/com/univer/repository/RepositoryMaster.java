package com.univer.repository;

import com.univer.models.MasterModels;

public abstract class RepositoryMaster <E>{
    private MasterModels[] newArray;
    private static int size = 5;
    private MasterModels[] myArray;

    private int index;
    private MasterModels[] myArrayTemp;
    private int number;
    private int n=1;

    public void repositoryMaster() {
        this.myArray = new MasterModels[size];
    }
    public   void add(E masterModels) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == null) {
                myArray[i] = (MasterModels) masterModels;
                break;
            } else if (myArray[i] != null && i == myArray.length - 1) {
                myArrayTemp = myArray;
                myArray = new MasterModels[myArray.length * 3 / 2 + 1];
                System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);//change capacity of array
            }

        }
        newArray = myArray;
    }
    public   void add(int index, E masterModels) {
        this.index=index;
        if (index > newArray.length) {
            myArrayTemp =  myArray;
            myArray =  new MasterModels[index];
            System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);
            myArray[index] = (MasterModels) masterModels;
        } else {
            myArrayTemp = myArray;
            myArray =  new MasterModels[myArray.length + 1];
            System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);
            for (int i = myArray.length-1; i > index; i--) {
                myArray[i] = myArray[i - 1];
            }
            myArray[index] = (MasterModels) masterModels;
        }
        newArray = myArray;
    }
    public  E  get(int index) {
        for (int i = 0; i < newArray.length; i++) {
            if (i==index) {
                MasterModels wer = newArray[i];
                return (E) wer;
            }
        }
        return null;
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

    public int size() {
        return myArray.length;
    }

    public void remove(int number) {
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
