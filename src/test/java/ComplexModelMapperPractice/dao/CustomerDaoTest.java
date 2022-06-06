package ComplexModelMapperPractice.dao;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@HelidonTest
public class CustomerDaoTest {

    @Inject
    private CustomerDao customerDao;

    @Test
    public void testEntitManager() throws DaoException{
        customerDao.printEntityManager();
    }

}
