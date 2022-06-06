/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package sample.practice.PreCon.MapPractice;

import java.util.*;
import java.util.function.Function;

public class MapEntry {

    public static void main(String[] args) {

        Map.Entry<Integer, String> testEntryMap = new AbstractMap.SimpleEntry<>(1, "2");
        System.out.println(testEntryMap);

        Function<Map.Entry<Integer, String>, String> strings = e -> e.getValue();
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Sudheer");
        map.put(2, "Mounika");

        List<String> stringList = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            stringList.add(strings.apply(entry));
        }

        System.out.println(stringList);
    }
}
