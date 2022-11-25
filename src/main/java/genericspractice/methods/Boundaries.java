/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package genericspractice.methods;

import java.util.ArrayList;
import java.util.List;

public class Boundaries {

    // This method says it supports all the functions that returns the List<M>, the return type supports all the classes that are of
    // type Integer and its subclasses.

    // We can simply return List<Integer> and all the things that are returned should be in the form of generics.
    public <M extends Integer> List<M> getIntegerList(){

        List<M> list = new ArrayList<>();
        return list;
    }

    public List<? super Integer> getSuperIntegerList(){
        List<? super Integer> list = new ArrayList<>();

        return list;
    }
}
