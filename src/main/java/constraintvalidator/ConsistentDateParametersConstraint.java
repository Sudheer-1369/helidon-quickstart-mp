/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package constraintvalidator;

import java.lang.annotation.Annotation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class ConsistentDateParametersConstraint<A extends Annotation, T extends Employee>
    implements ConstraintValidator<A, T> {

  Logger logger = Logger.getLogger(ConsistentDateParametersConstraint.class.getName());

  @Override
  public void initialize(A constraintAnnotation) {
    /**
     * What we can do here is in the annotation itself we can define any field which can store out
     * required field value and while using the annotation we can declare the value and during the
     * initialization we can get the value from the annotation and proceed using the annotation.
     */
  }

  @Override
  public boolean isValid(T value, ConstraintValidatorContext context) {

    logger.log(Level.INFO, "Inside the isValid method");

    context.disableDefaultConstraintViolation();
    context
        .buildConstraintViolationWithTemplate("Date of birth should be before the date of joining")
        .addConstraintViolation();
    return value.getDateOfBirth().before(value.getJoiningDate());
  }
}
