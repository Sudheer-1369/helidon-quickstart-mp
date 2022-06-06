package ComplexModelMapperPractice.service;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.dao.EmployeeDao;
import ComplexModelMapperPractice.entities.TraEmployee;
import ComplexModelMapperPractice.models.Employee;
import ComplexModelMapperPractice.models.Store;
import ComplexModelMapperPractice.services.EmployeeService;
import ComplexModelMapperPractice.services.StoreService;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;

@HelidonTest
public class EmployeeServiceTest {

    @Inject
    private EmployeeService employeeService;

    @Inject
    private EmployeeDao employeeDao;

    @Inject
    private StoreService storeService;

    private ModelMapper mapper = new ModelMapper();
    @Test
    public void testUpdateEmployee() throws DaoException{
        TraEmployee traEmployee = employeeDao.getEmployeeById(1L);
        Employee employee = mapper.map(traEmployee,Employee.class);
        employee.setStore(storeService.getStoreById(4L));
         employee = employeeService.updateEmployee(employee);

        System.out.println(employee);
    }
}
