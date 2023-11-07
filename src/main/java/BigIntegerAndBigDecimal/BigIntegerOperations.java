/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package BigIntegerAndBigDecimal;

import java.math.BigInteger;

/**
 * All the arthimetic operation like add,substract,multiply,division are also available in
 * BigInteger as well but using BigInteger we can perform the logical operations as well.
 */
public class BigIntegerOperations {
  public static void main(String[] args) {

    BigInteger i = new BigInteger("17");
    BigInteger j = new BigInteger("7");

    BigInteger and = i.and(j);
    BigInteger or = i.or(j);
    BigInteger not = j.not();
    BigInteger xor = i.xor(j);
    BigInteger andNot = i.andNot(j);
    BigInteger shiftLeft = i.shiftLeft(1);
    BigInteger shiftRight = i.shiftRight(1);

    System.out.println(and);
    System.out.println(or);
    System.out.println(not);
    System.out.println(xor);
    System.out.println(andNot);
    System.out.println(shiftLeft);
    System.out.println(shiftRight);

    System.out.println("\n Some famous and useful bitwise operations");
    BigInteger bigInteger = new BigInteger("1018");
    System.out.println(bigInteger.bitCount());
    System.out.println(bigInteger.bitLength());
    System.out.println(bigInteger.getLowestSetBit());
  }
}
