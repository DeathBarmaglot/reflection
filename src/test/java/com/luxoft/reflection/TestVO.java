package com.luxoft.reflection;

import java.util.ArrayList;
import java.util.Iterator;

public class TestVO implements Iterable {
    final int TEST = 0;
    boolean isDefaultConstructor;
    boolean isDefaultConstructorWithInt;
    ArrayList arrayList;

    public TestVO(){
        isDefaultConstructor = true;
        arrayList = null;
        new TestVO(TEST);

    }
    public TestVO(int value){
        isDefaultConstructorWithInt = true;
    }

    public int getTEST() {
        return TEST;
    }


    private boolean getConstructor() {
        return isDefaultConstructorWithInt;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
