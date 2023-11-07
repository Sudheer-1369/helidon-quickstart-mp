/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package bigIntegerandbigdecimal;

import java.math.BigInteger;

public class BigIntegerPractice {
  public static void main(String[] args) {
    BigInteger biFromString = new BigInteger("12121");
    BigInteger biFromByteArray = new BigInteger(new byte[] {1, 2, 3, 4});

    System.out.println(biFromString);
    System.out.println(biFromByteArray);

    // Using valueOf

    BigInteger biFromLong = BigInteger.valueOf(1212131213231L);
    System.out.println(biFromLong);
  }
}
