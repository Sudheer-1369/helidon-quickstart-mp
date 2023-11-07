/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package constraintvalidator;

import java.sql.Date;

public interface EmployeeCheck {

  Date getJoiningDate();

  Date getDateOfBirth();

  default boolean validateDates() {
    return getDateOfBirth().before(getJoiningDate());
  }
}
