/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements BaseDto<Long> {

  private Long id;
  private String lastName;
  private String firstName;
  private Integer age;
  private Integer salary;
  private String joiningDate;
}
