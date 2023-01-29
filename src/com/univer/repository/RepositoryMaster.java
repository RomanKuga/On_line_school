package com.univer.repository;

import com.univer.models.MasterModels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class RepositoryMaster implements InterfaceRepository<MasterModels>  {
//    private MasterModels newArray;
//    private static int size = 5;
    private List<MasterModels> modelsList;

//    private int index;
//    private MasterModels[] myArrayTemp;

    @Override
    public void interfaceRepository() {
        this.modelsList = new ArrayList<>();
    }

    public List<MasterModels> getModelsList() {
        return modelsList;
    }
    @Override
    public List<MasterModels> findAll() {
        Iterator<MasterModels> iterator = modelsList.iterator();
        while (iterator.hasNext()){
            if (iterator.next()==null){
                iterator.remove();
            }
        }
        return  modelsList;

    }
    //    @Override
//    public void add(int index, MasterModels masterModels) {
//        this.index = index;
//        if (index > newArray.length) {
//            myArrayTemp = myArray;
//            myArray = new MasterModels[index];
//            System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);
//            myArray[index] = masterModels;
//        } else {
//            myArrayTemp = myArray;
//            myArray = new MasterModels[myArray.length + 1];
//            System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);
//            for (int i = myArray.length - 1; i > index; i--) {
//                myArray[i] = myArray[i - 1];
//            }
//            myArray[index] = masterModels;
//        }
//        newArray = myArray;
//    }
//
//    @Override
//    public void add(MasterModels masterModels) {
//        for (int i = 0; i < myArray.length; i++) {
//            if (myArray[i] == null) {
//                myArray[i] = masterModels;
//                break;
//            } else if (myArray[i] != null && i == myArray.length - 1) {
//                myArrayTemp = myArray;
//                myArray = new MasterModels[myArray.length * 3 / 2 + 1];
//                System.arraycopy(myArrayTemp, 0, myArray, 0, myArrayTemp.length);//change capacity of array
//            }
//
//        }
//        newArray = myArray;
//    }
//
//    @Override
//    public void interfaceRepository() {
//        this.myArray = new MasterModels[size];
//    }
//
//
//    public MasterModels get(int index) {
//
//       if (index>myArray.length){
//           throw new EntityNotFoundException("Елемент за межами масиву");
//       }
//       return myArray[index];
//    }
//
//
//
//
//    public int getIndex() {
//        return index;
//    }
//
//    public int size() {
//        return myArray.length;
//    }
//
//    public void remove(int number) {
//        for (int i = 0; i < newArray.length; i++) {
//            if (newArray[i] != null) {
//                MasterModels wer = newArray[i];
//                if (wer.getID() == number) {
//                    for (int j = i; j < newArray.length - 1; j++) {
//                        newArray[j] = newArray[j + 1];
//                    }
//                }
//            }
//        }
//
//    }
//
//    public boolean isEmpty() {
//        for (int i = 0; i < newArray.length; i++) {
//            if (newArray[i] != null) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
}
