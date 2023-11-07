/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package stringspractice;

public class StringReplace {
  public static void main(String[] args) {
    String format = "YYYYMMDD";
    String format1 = "DDMMYYYY";

    format = format.replace('Y', 'y').replace('D', 'd').replace('m', 'M');
    format1 = format1.replace('Y', 'y').replace('D', 'd').replace('m', 'M');
    System.out.println(format);
    System.out.println(format1);
  }
}
