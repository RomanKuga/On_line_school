package com.univer.utilities;

import com.univer.models.MasterModels;

public class Simpleiterator implements SimpleiteratorInt<MasterModels> {
    private MasterModels[] array;
    private MasterModels[] tmpArray;
    private MasterModels[] tmpArrayNew;
    private static int inex = -1;
    private static int rt = 0;

    public Simpleiterator(MasterModels[] array) {
        this.array = array;
    }

    @Override
    public MasterModels[] getModel() {
        return tmpArray;
    }

    @Override
    public boolean hesNext() {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (inex < array.length - 1) {
                inex++;
                result = true;
                return result;
            }

        }
        return false;
    }

    @Override
    public MasterModels next() {
        return array[inex];
    }

    @Override
    public void remove() {
        rt++;
        tmpArray = new MasterModels[array.length - rt];
        if (inex == 0) {
            System.arraycopy(array, 1, tmpArray, 0, array.length - rt);
        } else if (inex == array.length - 1) {
            if (rt == 1) {
                System.arraycopy(array, 0, tmpArray, 0, array.length - rt);
            } else {
                System.arraycopy(tmpArrayNew, 0, tmpArray, 0, array.length - rt);
            }
        } else if (rt == 1) {
            System.arraycopy(array, 0, tmpArray, 0, inex);
            System.arraycopy(array, inex + 1, tmpArray, inex, array.length - inex - rt);
        } else {
            System.arraycopy(tmpArrayNew, 0, tmpArray, 0, inex);
            System.arraycopy(array, inex + 1, tmpArray, inex, array.length - inex - rt);
        }
        tmpArrayNew = new MasterModels[array.length - rt];
        tmpArrayNew = tmpArray;

    }
}
