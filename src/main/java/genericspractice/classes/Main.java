/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package genericspractice.classes;

class TwoD { // from   ww w .  j  a va2  s.co m
  int x, y;

  TwoD(int a, int b) {
    x = a;
    y = b;
  }
}

// Three-dimensional coordinates.
class ThreeD extends TwoD {
  int z;

  ThreeD(int a, int b, int c) {
    super(a, b);
    z = c;
  }
}

class Map<T extends TwoD> {
  T[] coords;

  Map(T[] o) {
    coords = o;
  }
}

public class Main {
  static void showXY(Map<?> c) {
    for (int i = 0; i < c.coords.length; i++) {
      System.out.println(c.coords[i].x + " " + c.coords[i].y);
    }
  }

  static void showXYZ(Map<? extends ThreeD> c) {
    for (int i = 0; i < c.coords.length; i++) {
      System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
    }
  }

  public static void main(String args[]) {
    TwoD td[] = {new TwoD(0, 0), new TwoD(-1, -2)};
    Map<TwoD> map = new Map<TwoD>(td);
    System.out.println("Contents of tdlocs.");

    showXY(map);
    //        showXYZ(map);  This method will throw an exception
  }
}

// Generic array creation is not possible

// class MyClass<T extends Number> {
//    T ob;/*from w  w  w  .  j av  a  2s .co  m*/
//    T vals[];
//
//    MyClass(T o, T[] nums) {
//        ob = o;
//        vals = nums;
//    }
// }
//
// public class Main {
//    public static void main(String args[]) {
//        Integer n[] = { 1 };
//        MyClass<Integer> iOb = new MyClass<Integer>(50, n);
//        // Can't create an array of type-specific generic references.
//        // Gen<Integer> gens[] = new Gen<Integer>[10];
//        MyClass<Integer> gens[] = new MyClass<Integer>[10]; // OK
//    }
// }
