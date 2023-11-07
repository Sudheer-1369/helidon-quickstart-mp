package util;

import complexmodelmapperpractice.entities.TraEmployee;
import complexmodelmapperpractice.entities.TraStore;
import java.sql.Timestamp;
import javax.inject.Inject;

public class EntityUtil {

  @Inject TraStore traStore;

  public static TraStore getTraStore(String code, String storeLineNumber) {
    TraStore traStore = new TraStore();
    traStore.setCode(code);
    traStore.setStoreLineNumber(storeLineNumber);
    return traStore;
  }

  public static TraEmployee getTraEmployee(
      String firstName,
      String lastName,
      int age,
      String landLineNumber,
      long salary,
      Timestamp timestamp) {
    TraEmployee traEmployee = new TraEmployee();
    traEmployee.setFirstName(firstName);
    traEmployee.setLastName(lastName);
    traEmployee.setAge(age);
    traEmployee.setLandLineNumber(landLineNumber);
    traEmployee.setSalary(salary);
    traEmployee.setTimeStamp(timestamp);

    return traEmployee;
  }
}
