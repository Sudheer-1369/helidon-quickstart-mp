/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package bigIntegerandbigdecimal;

import java.math.BigDecimal;

public class BigdecimalOperations {

  public static void main(String[] args) {
    BigDecimal bd = BigDecimal.valueOf(121323132L, 3);

    System.out.println(bd.precision());
    System.out.println(bd.unscaledValue());
    System.out.println(bd.scale());

    // Some compare operations are done here

    BigDecimal bd1 = new BigDecimal("1.0");
    BigDecimal bd2 = new BigDecimal("1.00");
    BigDecimal bd3 = new BigDecimal("2.0");

    System.out.println(bd1.compareTo(bd3) < 0);
    System.out.println(bd3.compareTo(bd1) > 0);
    System.out.println(bd1.compareTo(bd2) == 0);
    System.out.println(bd1.compareTo(bd3) <= 0);
    System.out.println(bd1.compareTo(bd2) >= 0);
    System.out.println(bd1.compareTo(bd3) != 0);

    System.out.println("Arthimetic operations start here");
    BigDecimal bigDecimal = new BigDecimal("2.00");
    BigDecimal bigDecimal1 = new BigDecimal("3.20");

    BigDecimal substraction = bigDecimal1.subtract(bigDecimal);
    BigDecimal division = bigDecimal1.divide(bigDecimal);
    BigDecimal multiplication = bigDecimal1.multiply(bigDecimal);
    BigDecimal addition = bigDecimal1.add(bigDecimal);

    System.out.println(substraction);
    System.out.println(division);
    System.out.println(multiplication);
    System.out.println(addition);
  }
}
