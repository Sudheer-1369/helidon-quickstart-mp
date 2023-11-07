/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package Interceptors;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class InterceptorCheck {

  @AroundDao
  public long divide(int x, int y) throws Exception {

    return (long) x / y;
  }
}
