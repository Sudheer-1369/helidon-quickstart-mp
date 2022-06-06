/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package StringsPractice;

public class StringSplit {

    public static void main(String[] args) {

        String str = "name, age desc";

        System.out.println(str.split(",").getClass());

        String[] splitString = str.split(",");

        for (String s : splitString) {
            System.out.println(s.trim());
        }
    }
}
