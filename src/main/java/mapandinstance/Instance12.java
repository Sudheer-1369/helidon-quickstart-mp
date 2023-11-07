package mapandinstance;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@ApplicationScoped
@Named("Instance1")
public class Instance12 implements BaseInstance {
  @Override
  public void baseTest() {

    System.out.println("Inside instance 1");
  }

  @Override
  public String getType() {
    return "Instance1";
  }
}
