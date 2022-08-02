/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package constraintvalidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = DtoValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE})
@Documented
public @interface ConsistentDateParameters {

    String message() default "The Date of birth should always be before the date of joining";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String condition() default "greater";
}
