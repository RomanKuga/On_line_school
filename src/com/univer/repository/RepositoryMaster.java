package com.univer.repository;

import com.univer.models.MasterModels;
import com.univer.service.ServiceRepository;

import java.util.Arrays;

public abstract class RepositoryMaster {
    private MasterModels[] newArray;
    private static int size = 5;
    private RepositoryMaster myArray;
    private int number;
    private int index;
    private MasterModels[] myArrayTemp;

    public void DataMaster() {
        new ServiceRepository<MasterModels>();
    }

    public void elementToAdd(MasterModels masterModels) {
      ServiceRepository<MasterModels> wer = new ServiceRepository<>();
      wer.add(masterModels);



//        for (int i = 0; i < myArray.length; i++) {
//            if (myArray[i] == null) {
//                myArray[i] = (T) masterModels;
//                break;
//            } else if (myArray[i] != null && i == myArray.length - 1) {
//                myArrayTemp = (T[]) myArray;
//                myArray = (T[]) new Object[myArray.length * 3 / 2 + 1];
//                System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);//change capacity of array
//            }
//
//        }
//        newArray = (T[]) myArray;
    }

    public MasterModels[] getAll() {
    MasterModels[] sd = (MasterModels[]) new ServiceRepository<>().get();
        System.out.println(Arrays.toString(sd));
        return sd;
    }
//
//    public void getByld(int number) {
//        this.number = number;
//        for (int i = 0; i < newArray.length; i++) {
//            if (newArray[i] != null) {
//                MasterModels wer = (MasterModels) newArray[i];
//                if (wer.getID() == number) {
//                    System.out.println(newArray[i]);
//                    index = i;
//                }
//            }
//        }
//    }
//
//    public int getIndex() {
//        return index;
//    }
//
    public int lengthArray() {
        int lengthArray= new ServiceRepository<>().lengthArray();
        return lengthArray;
    }


//
//    public void deleteByld(int number) {
//        this.number = number;
//        for (int i = 0; i < newArray.length; i++) {
//            if (newArray[i] != null) {
//                MasterModels wer = (MasterModels) newArray[i];
//                if (wer.getID() == number) {
//                    for (int j = i; j < newArray.length - 1; j++) {
//                        newArray[j] = newArray[j + 1];
//                    }
//                }
//            }
//        }
//
//    }
}
