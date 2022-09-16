package ComplexModelMapperPractice.dao;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.entities.TraEmployee;
import ComplexModelMapperPractice.entities.TraStore;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;
import util.EntityUtil;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Logger;

@HelidonTest
public class EmployeeDaoTest {

    private static final Logger logger = Logger.getLogger(EmployeeDaoTest.class.getName());
    @Inject
    EmployeeDao employeeDao;

    @Inject
    StoreDao storeDao;

    @Test
    public void testAddEmployee() throws DaoException {

        TraEmployee traEmployee = EntityUtil.getTraEmployee("Sudheer", "Patnana", 25, "8919624673", 15000000, new Timestamp(new Date().getTime()));
        TraStore traStore = storeDao.getStoreById(4L);
        traEmployee.setTraStore(traStore);

        employeeDao.addEmployee(traEmployee);

        logger.info("The added employee is : " + traEmployee);
    }

    @Test
    public void testUpdateEmployee() throws DaoException {
        TraEmployee traEmployee = employeeDao.getEmployeeById(1L);
        //traEmployee.setTraStore(storeDao.getStoreById(4L));
//        traEmployee.setStoreId(1L);
        logger.info("Before Update employee is : " + traEmployee);
        employeeDao.updateEmployee(traEmployee);
        logger.info("just after Update employee is : " + traEmployee);
        traEmployee = employeeDao.getEmployeeById(1L);
        logger.info("Update employee is : " + traEmployee);
    }
}
