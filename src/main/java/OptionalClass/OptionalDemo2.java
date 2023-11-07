/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package OptionalClass;

import java.util.Optional;

public class OptionalDemo2 {

  public static void main(String[] args) {

    Optional<String> str = Optional.empty();

    System.out.println(str.isPresent());

    System.out.println(str == null);
  }
}
