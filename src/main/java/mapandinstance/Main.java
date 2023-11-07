/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package mapandinstance;

import java.util.Iterator;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.jboss.weld.literal.NamedLiteral;

@ApplicationScoped
public class Main {

  private final Instance<BaseInstance> baseInstances;

  @Inject
  Main(Instance<BaseInstance> baseInstances) {
    this.baseInstances = baseInstances;
  }

  public void mainMethod() {

    System.out.println(baseInstances.stream().count());
    Iterator<BaseInstance> baseInstanceIterator = baseInstances.iterator();

    while (baseInstanceIterator.hasNext()) {
      var instance = baseInstanceIterator.next();
      System.out.println(instance.getClass().getSimpleName());
      instance.baseTest();
    }
  }

  public void mainMethod2(String type) {
    var instance = baseInstances.select(new NamedLiteral(type)).get();
    instance.baseTest();
  }
}
