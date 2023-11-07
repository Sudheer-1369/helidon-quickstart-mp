/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package enumpractice;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

enum OrderByDirection {
  equal(":"),
  like("~"),
  greater(">"),
  lesser("<");

  public static final Map<String, OrderByDirection> LOOKUP =
      EnumSet.allOf(OrderByDirection.class).stream()
          .collect(Collectors.toMap(OrderByDirection::getOper, Function.identity()));
  private final String oper;

  OrderByDirection(String oper) {
    this.oper = oper;
  }

  public String getOper() {
    return oper;
  }
  //            EnumSet.allOf(OrderByDirection.class).stream()
  //                    .collect(Collectors.toMap(OrderByDirection::getOper, Function.identity()));
}

public class PracticeEnum {
  public static void main(String[] args) {
    System.out.println(OrderByDirection.LOOKUP);
  }
}
