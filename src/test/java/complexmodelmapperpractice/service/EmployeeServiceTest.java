package complexmodelmapperpractice.service;

import complexmodelmapperpractice.commonexceptions.DaoException;
import complexmodelmapperpractice.dao.EmployeeDao;
import complexmodelmapperpractice.entities.TraEmployee;
import complexmodelmapperpractice.models.Employee;
import complexmodelmapperpractice.services.EmployeeService;
import complexmodelmapperpractice.services.StoreService;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

@HelidonTest
public class EmployeeServiceTest {

  private final ModelMapper mapper = new ModelMapper();
  @Inject private EmployeeService employeeService;
  @Inject private EmployeeDao employeeDao;
  @Inject private StoreService storeService;

  @Test
  public void testUpdateEmployee() throws DaoException {
    TraEmployee traEmployee = employeeDao.getEmployeeById(1L);
    Employee employee = mapper.map(traEmployee, Employee.class);
    employee.setStore(storeService.getStoreById(4L));
    employee = employeeService.updateEmployee(employee);

    System.out.println(employee);
  }
}
