/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package genericspractice.methods;

import java.util.LinkedList;
import java.util.List;

public class WrongPractice {

    public static void main(String[] args) throws ClassCastException{
        List list = new LinkedList<>(); // Understood that when collection is created without mentioning the datatype it will take the input as Object.

        list.add(1);
        short i = (short) list.get(0);  // Since the returned element is of type Object we need to type cast it, and we know the effects of typecasting.
        // This will throw an exception called ClassCast Exception.
        System.out.println(i);

    }
}
