/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package constraintvalidator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConsistentDateParameters
public class Employee {

    @NotNull
    private Integer age;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private Date joiningDate;

}
