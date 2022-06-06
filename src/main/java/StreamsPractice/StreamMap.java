/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package StreamsPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamMap {

    static final Map<String, String> map = Arrays.stream(new String[]{"1", "2", "3"})
            .collect(Collectors.toMap(s -> s + "1", Function.identity()));

    static final Map<String, List<String>> multiValuedMap
            = Arrays.stream(new String[]{"1", "2", "3"})
            .collect(Collectors.groupingBy(Function.identity(), Collectors.mapping(Function.identity(), Collectors.toList())));

    static final Map<String, List<String>> filteredMap
            = Arrays.stream(new String[]{"1", "2", "3"})
            .collect(Collectors.groupingBy(s -> "key", Collectors.filtering(s -> s.equals("1"), Collectors.toList())));

    public static void main(String[] args) {
        System.out.println("Map obtained from the stream is " + map);

        System.out.println("Map obtained by collecting and grouping the values from stream is " + multiValuedMap);

        System.out.println("Map obtained by collecting and filtering the values from stream is " + filteredMap);
    }
}
