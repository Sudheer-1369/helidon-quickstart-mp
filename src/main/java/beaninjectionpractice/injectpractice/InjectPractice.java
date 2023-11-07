/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package beaninjectionpractice.injectpractice;

import beaninjectionpractice.BeanInjection;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class InjectPractice {

  private final BeanInjection type;

  @Inject
  public InjectPractice(BeanInjection type) {
    this.type = type;
  }

  public void testType() {
    System.out.println("The bean type is " + this.type);
  }
}
