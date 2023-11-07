/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package methodhandles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Utils {

  private static MethodHandles.Lookup lookup = MethodHandles.lookup();

  private static Map<Class<?>, MethodHandle> fromActionMethodHandles = new HashMap<>();

  public static DomainEnum fromMethod(Class<?> domainEnumType, String action) throws Throwable {

    try {
      MethodHandle reverseLookUp =
          Optional.ofNullable(fromActionMethodHandles.get(domainEnumType))
              .orElseGet(() -> createAndStoreReverseLookUp(domainEnumType));

      return (DomainEnum) reverseLookUp.invoke(action);
    } catch (ReverseLookUpException e) {
      e.printStackTrace();
      throw new Exception("Exception occurred in create and store reverlookup method");
    }
  }

  public static MethodHandle createAndStoreReverseLookUp(Class<?> domainEnumType) {

    try {
      MethodType mt = MethodType.methodType(domainEnumType, String.class);
      MethodHandle fromAction = lookup.findStatic(domainEnumType, "fromAction", mt);
      fromActionMethodHandles.put(domainEnumType, fromAction);

      return fromAction;
    } catch (NoSuchMethodException | IllegalAccessException e) {
      e.printStackTrace();
      throw new ReverseLookUpException("Exception occurred in create and store reverlookup method");
    }
  }

  static class ReverseLookUpException extends RuntimeException {
    public ReverseLookUpException(String message) {
      super(message);
    }
  }
}
