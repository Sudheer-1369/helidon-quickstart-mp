/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package OptionalClass;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalDemo1 {

  public static final Logger logger = Logger.getLogger(OptionalDemo1.class.getName());

  static String getDefault() {
    return "Sudheer kumar patnana";
  }

  public static void main(String[] args) {

    String[] str = new String[5];

    str[1] = "Sudheer Loves Rajnikanth";

    Optional<String> empty = Optional.empty();
    logger.log(Level.INFO, () -> String.format("The Obtained Optional is %s", empty));

    Optional<String> value = Optional.of(str[1]);
    logger.log(Level.INFO, () -> String.format("The Obtained Optional1 is %s", value));
    logger.log(Level.INFO, () -> String.format("The value in the option is %s", value.get()));
    logger.log(Level.INFO, () -> String.format("The Hashcode value is %s", value.hashCode()));
    logger.log(Level.INFO, () -> String.format("The existence value is %s", value.isPresent()));
    logger.log(Level.INFO, () -> String.format("The Check value is %s", value.isEmpty()));

    String defaultValue = Optional.of("Rajnikanth").orElse("Sudheer");
    logger.log(Level.INFO, String.format("The default/value1 is %s", defaultValue));

    defaultValue = Optional.ofNullable(str[1]).orElseGet(OptionalDemo1::getDefault);
    logger.log(Level.INFO, String.format("The default/value2 is %s", defaultValue));

    Optional<String> op = Optional.empty();
    try {
      logger.log(
          Level.INFO,
          () ->
              String.format(
                  "The optional throws the error %s",
                  op.orElseThrow(IllegalArgumentException::new)));
    } catch (Exception e) {
      logger.log(Level.INFO, () -> "The error/exception message is " + e.getMessage());
    }

    Optional<String> op1 = Optional.of("Sudheer");
    String output =
        op1.map(s -> s + " Kumar Patnana").orElse("Patnana Sudheer Kumar And Rajnikanth");
    logger.log(Level.INFO, output);

    List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
    Optional<List<String>> listOptional = Optional.ofNullable(companyNames);

    System.out.println(listOptional);
    System.out.println(listOptional.map(List::size).orElse(20));

    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6);
    Optional<List<Integer>> optionalList = Optional.of(integerList);

    List<Integer> integers =
        optionalList.orElse(Arrays.asList(1, 2, 3)).stream()
            .filter(p -> p > 2)
            .collect(Collectors.toList());

    System.out.println(integers);

    List<Optional<Integer>> optionals =
        Arrays.asList(Optional.of(1), Optional.of(2), Optional.of(3));
    List<Integer> integersList =
        optionals.stream().map(Optional::get).filter(p -> p < 22).collect(Collectors.toList());
    System.out.println(integersList);

    //        Optional<String> nullCheck = null;
    //        System.out.println(nullCheck.get());  // Will throw nullPointer exception
    //
    Stream<Integer> stringStream =
        optionals.stream().flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty());
    System.out.println(stringStream);

    String practice = Optional.ofNullable(null).map(s -> s + " kumar").orElse("Sudheer Patnana");
    System.out.println("The practice is " + practice);

    Optional<List<Integer>> optionalList1 = Optional.ofNullable(Arrays.asList(1, 2, 34, 5, 6));
    List<Integer> integers1 =
        optionalList1.filter(s -> s.size() > 4).orElse(Arrays.asList(22, 3, 323, 2, 23));
    for (Integer i : integers1) System.out.print(" The i is " + i);

    String[] str1 = new String[] {"sudheer", "Rajnikanth"};
    String[] str2 = new String[] {"sudheer", "Rajnikanth"};
    String[] str3 = new String[] {"sudheer", "Rajnikanth"};
    List<String[]> strings = Optional.ofNullable(Arrays.asList(str1, str2, str3)).orElse(null);
    List<String> strings1 = strings.stream().map(OptionalDemo1::mapTo).collect(Collectors.toList());

    for (String stri : strings1) {
      System.out.println(stri);
    }
  }

  public static String mapTo(String[] strings) {

    String s = "";
    for (String str : strings) {
      s = s + str;
    }
    return s;
  }
}
