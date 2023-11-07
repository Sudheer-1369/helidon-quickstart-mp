/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package mapandinstance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("Instance2")
public class Instance22 implements BaseInstance {
  @Override
  public void baseTest() {

    System.out.println("Inside instance 2");
  }

  @Override
  public String getType() {
    return "Instance2";
  }
}
