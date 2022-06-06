/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package OptionalClass;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalDemo1 {

    static String getDefault() {
        return "Sudheer kumar patnana";
    }

    public static void main(String[] args) {

        String[] str = new String[5];

        str[1] = "Sudheer Loves Mounika";

        Optional<String> empty = Optional.empty();
        System.out.println(empty);

        Optional<String> value = Optional.of(str[1]);
        System.out.println(value.get());
        System.out.println(value.hashCode());
        System.out.println(value.isPresent());
        System.out.println(value.isEmpty());

        String defaultValue = Optional.ofNullable((String) null).orElse("Sudheer");
        System.out.println(defaultValue);

        defaultValue = Optional.ofNullable(str[1]).orElseGet(OptionalDemo1::getDefault);
        System.out.println(defaultValue);

        defaultValue = Optional.ofNullable(str[1]).orElseThrow(IllegalArgumentException::new);
        System.out.println(defaultValue);

        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.ofNullable(companyNames);

        System.out.println(listOptional);
        System.out.println(listOptional.map(List::size).get());

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<List<Integer>> optionalList = Optional.of(integerList);

        List<Integer> integers = optionalList.orElse(Arrays.asList(1, 2, 3)).stream().filter(p -> p > 2).collect(Collectors.toList());

        System.out.println(integers);

        List<Optional<Integer>> optionalList1 = Arrays.asList(Optional.of(1), Optional.of(2), Optional.of(3));
        List<Integer> integers1 = optionalList1.stream().map(Optional::get).filter(p -> p < 10).collect(Collectors.toList());
        System.out.println(integers1);

//        Optional<String> nullCheck = null;
//        System.out.println(nullCheck.get());  // Will throw nullPointer exception

        Stream<Integer> stringStream = optionalList1.stream().flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty());
    }
}
