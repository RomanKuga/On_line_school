package com.univer.repository;

import com.univer.models.MasterModels;

public abstract class RepositoryMaster implements InterfaceRepository {
    private MasterModels[] newArray;
    private static int size = 5;
    private MasterModels[] myArray;

    private int index;
    private MasterModels[] myArrayTemp;
    private int number;
    private int n = 1;

    @Override
    public void add(int index, MasterModels masterModels) {
        this.index = index;
        if (index > newArray.length) {
            myArrayTemp = myArray;
            myArray = new MasterModels[index];
            System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);
            myArray[index] = masterModels;
        } else {
            myArrayTemp = myArray;
            myArray = new MasterModels[myArray.length + 1];
            System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);
            for (int i = myArray.length - 1; i > index; i--) {
                myArray[i] = myArray[i - 1];
            }
            myArray[index] = masterModels;
        }
        newArray = myArray;
    }

    @Override
    public void add(MasterModels masterModels) {
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] == null) {
                myArray[i] = masterModels;
                break;
            } else if (myArray[i] != null && i == myArray.length - 1) {
                myArrayTemp = myArray;
                myArray = new MasterModels[myArray.length * 3 / 2 + 1];
                System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);//change capacity of array
            }

        }
        newArray = myArray;
    }

    @Override
    public void interfaceRepository() {
        this.myArray = new MasterModels[size];
    }


    public MasterModels get(int index) {

       if (index>myArray.length){
           throw new ArrayIndexOutOfBoundsException("EntityNotFoundException");
       }

//        for (int i = 0; i < newArray.length; i++) {
//            if (i == index) {
//                MasterModels wer = newArray[i];
//                return wer;
//            }
//        }
        return myArray[index];
    }


    public <E> void getByld(int number) {
        this.number = number;
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] != null) {
                MasterModels wer = newArray[i];
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
                MasterModels wer = newArray[i];
                if (wer.getID() == number) {
                    for (int j = i; j < newArray.length - 1; j++) {
                        newArray[j] = newArray[j + 1];
                    }
                }
            }
        }

    }

    public boolean isEmpty() {
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] != null) {
                return true;
            }
        }
        return false;
    }
}
