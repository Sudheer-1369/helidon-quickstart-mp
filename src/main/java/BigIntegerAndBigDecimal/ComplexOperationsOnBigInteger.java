/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package BigIntegerAndBigDecimal;

import java.math.BigInteger;

public class ComplexOperationsOnBigInteger {
    public static void main(String[] args) {
        BigInteger i = new BigInteger("31");
        BigInteger j = new BigInteger("24");
        BigInteger k = new BigInteger("16");

        BigInteger gcd = i.gcd(j);
        BigInteger mod = i.multiply(j).mod(k);
        BigInteger modPow = j.modPow(k, i); // --> j power k mod i
        BigInteger modInverse = j.modInverse(i);

        System.out.println(gcd);
        System.out.println(mod);
        System.out.println(modPow);
        System.out.println(modInverse);

        System.out.println("Convert a BigInteger to int");

        BigInteger bigInteger = new BigInteger("123445");
        int intValue = bigInteger.intValue();
        long longValue = bigInteger.longValue();

        System.out.println(intValue + " and " + longValue);

    }
}
