/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package BigIntegerAndBigDecimal;

import java.math.BigDecimal;

/**
 * BigDecimal represents an immutable arbitrary-precision signed decimal number.
 * We use BigDecimal for high-precision arithmetic.
 * We also use it for calculations requiring control over scale and rounding off behavior
 */
public class BigDecimalPractice {
    public static void main(String[] args) {
        BigDecimal bdFromString = new BigDecimal("0.2");
        BigDecimal bdFromLong = new BigDecimal(12121324L);
        BigDecimal bdFromInt = new BigDecimal(123);
        BigDecimal bdFromCharArray = new BigDecimal(new char[]{'9', '.', '9'});

        System.out.println(bdFromString);
        System.out.println(bdFromLong);
        System.out.println(bdFromInt);
        System.out.println(bdFromCharArray);

        /**
         * Another way of creating a BigDecimal is to use static method valueOf present in the BigDecimal
         */

        System.out.println("Here starts a different approach of getting a BigDecimal");
        BigDecimal bdByLong = BigDecimal.valueOf(12121324L, 2);
        BigDecimal bdByDouble = BigDecimal.valueOf(0.1d);

        System.out.println(bdByLong);
        System.out.println(bdByDouble);

    }
}
