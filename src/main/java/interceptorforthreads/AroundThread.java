/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package interceptorforthreads;

import java.lang.annotation.*;
import javax.interceptor.InterceptorBinding;

@Inherited
@InterceptorBinding
@Target({
  ElementType.TYPE,
  ElementType.METHOD,
  ElementType.FIELD,
  ElementType.ANNOTATION_TYPE,
  ElementType.CONSTRUCTOR
})
@Retention(RetentionPolicy.RUNTIME)
public @interface AroundThread {}
