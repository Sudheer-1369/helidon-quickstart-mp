/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package IntegerOverFlow;

import java.math.BigInteger;

/** In this case we can see that after the max reaches MAX_VALUE then it starts overflowing. */
public class IntegerWrapAround {

  public static void main(String[] args) {

    System.out.println("OverFlow can be seen here");
    int max = Integer.MAX_VALUE - 1;
    for (int i = 0; i < 4; i++) {
      System.out.println(max + i);
    }

    System.out.println("Underflow can be here");
    int min = Integer.MIN_VALUE + 1;
    for (int i = 0; i < 4; i++) {
      System.out.println(min - i);
    }

    System.out.println(BigInteger.TEN);
    System.out.println(BigInteger.TEN.intValueExact());
    System.out.println(BigInteger.TEN.longValueExact());
  }
}
