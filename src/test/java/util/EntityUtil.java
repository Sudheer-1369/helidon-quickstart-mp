package util;

import ComplexModelMapperPractice.entities.TraEmployee;
import ComplexModelMapperPractice.entities.TraStore;

import javax.inject.Inject;

public class EntityUtil {

    @Inject
    TraStore traStore;

    public static TraStore getTraStore(String code, String storeLineNumber) {
        TraStore traStore = new TraStore();
        traStore.setCode(code);
        traStore.setStoreLineNumber(storeLineNumber);
        return traStore;
    }

    public static TraEmployee getTraEmployee(String firstName, String lastName, int age, String landLineNumber, long salary) {
        TraEmployee traEmployee = new TraEmployee();
        traEmployee.setFirstName(firstName);
        traEmployee.setLastName(lastName);
        traEmployee.setAge(age);
        traEmployee.setLandLineNumber(landLineNumber);
        traEmployee.setSalary(salary);

        return traEmployee;
    }
}
