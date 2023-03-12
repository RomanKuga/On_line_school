package com.univer.utilities;

public interface SimpleiteratorInt<E> {
    boolean hesNext();
    E next();
    void remove();
    E[] getModel();
}
