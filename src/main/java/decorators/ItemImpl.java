/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package decorators;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemImpl implements decorators.Item {

  @Override
  public void draw(int x, int y) {
    System.out.println("Inside ItemImpl ");
  }

  public void fetch(int x) {
    System.out.println("Inside the ItemImpl fetch method");
  }
}
