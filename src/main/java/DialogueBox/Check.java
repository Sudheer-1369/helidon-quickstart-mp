/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package DialogueBox;

public class Check {
    public static void main(String[] args) {
        StaticTest staticTest = null;
        StaticTest.i++;
        StaticTest.i++;
        System.out.println(StaticTest.i);
        StaticTest staticTest1 = new StaticTest();
        StaticTest.i++;
        StaticTest.i++;

        System.out.println(StaticTest.i);
        System.out.println(StaticTest.i);

        System.out.println(StaticTest.getTheNumber());
        StaticTest.getI();
    }
}
