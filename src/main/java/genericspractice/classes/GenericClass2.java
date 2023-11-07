/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package genericspractice.classes;

interface GenericInterface2<T, S> {

  T getObj(S obj1, T obj2);
}

abstract class IntermediateClass<T extends Number, S extends Float>
    implements GenericInterface2<T, S> {

  public T getObj(S obj1, T obj2) {

    //        return true;
    return obj2;
  }
}

public class GenericClass2 extends IntermediateClass<Integer, Float> {}
