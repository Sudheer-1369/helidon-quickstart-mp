/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package sample.practice.PreCon.MapPractice;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Arrays;
import java.util.Collection;

public class MultiValuedMapPractice {

    public static void main(String[] args) {

        MultivaluedMap<String, String> mvm = new MultivaluedHashMap<>();
        mvm.put("fruits", Arrays.asList("apple", "oranges", "watermelon"));

        Collection<String> values = mvm.get("fruits");

        System.out.println(values);
    }

}
