/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import restapis.EnumValidator;
import restapis.YesNo;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company implements BaseDto<Long> {

  private Long id;
  private String name;
  private String phoneNumber;
  private List<Employee> employees;
    @EnumValidator(classType = YesNo.class, message = "Only YesNo No is allowed")
    private YesNo skipDuplicates;

}
