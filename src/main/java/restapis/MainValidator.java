/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.EnumSet;
import java.util.Set;

public class MainValidator implements ConstraintValidator<EnumValidator, YesNo> {

    private Class<? extends YesNo> classType;

    @Override
    public void initialize(EnumValidator constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
        classType = constraintAnnotation.classType();

    }

    @Override
    public boolean isValid(YesNo value, ConstraintValidatorContext constraintValidatorContext) {

        Set<? extends YesNo> set = EnumSet.allOf(YesNo.class);

        return value == null || set.contains(value);
    }
}
