/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.partialentities;

/**
 * Java records are similar to DTO projections which are used when we need to provide a read-only
 * support. records are supported from java 14 , they can be used in case of DTO's but not entities
 * due few reasons like: The entity should not have final columns/fields, it should have a no arg
 * constructor but incase of records there should be no noarg constructor as well as fields should
 * be final. For some reasons the poc is not supporting the records and few other things.
 */
// public record FunctioningCompanies(int id, String phoneNumber, String name) {
//    public static ListResultTransformer resultTransformer =
//            (tuples, aliases) -> new FunctioningCompanies(((Number) tuples[0]).intValue(),
// (String) tuples[1], (String) tuples[2]);
// }

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FunctioningCompanies {
  public static ListResultTransformer resultTransformer =
      (tuples, aliases) ->
          new FunctioningCompanies(
              ((Number) tuples[0]).intValue(), (String) tuples[1], (String) tuples[2]);
  private int id;
  private String phoneNumber;
  private String name;
}
