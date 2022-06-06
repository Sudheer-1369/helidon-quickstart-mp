/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package DialogueBox;

public class Check {
    public static void main(String[] args) {
        StaticTest staticTest = null;
        staticTest.i++;
        staticTest.i++;
        System.out.println(staticTest.i);
        StaticTest staticTest1 = new StaticTest();
        staticTest1.i++;
        staticTest1.i++;

        System.out.println(staticTest.i);
        System.out.println(staticTest1.i);

        System.out.println(staticTest.getTheNumber());
        staticTest.getI();
    }
}
