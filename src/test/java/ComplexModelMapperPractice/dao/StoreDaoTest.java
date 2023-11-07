package ComplexModelMapperPractice.dao;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.entities.TraStore;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;
import util.EntityUtil;

@HelidonTest
public class StoreDaoTest {

  private static final Logger logger = Logger.getLogger(StoreDaoTest.class.getName());

  @Inject StoreDao storeDao;

  @Test
  public void testAddStore() throws DaoException {
    TraStore traStore = EntityUtil.getTraStore("VP-MainStreet", "1234453324");
    storeDao.addStore(traStore);
  }

  @Test
  public void testGetStoreById() throws DaoException {
    TraStore traStore = storeDao.getStoreById(3L);
    logger.info("The store : " + traStore);
  }

  @Test
  public void testGetAllStores() throws DaoException {
    List<String> params = new ArrayList<>();
    params.add("code<VP-MainStreet");
    List<TraStore> traStoreList = storeDao.getAllTraStores(0, params);
    logger.info("The store List is : " + traStoreList);
  }

  @Test
  public void testGetTraStoreByCode() throws DaoException {
    TraStore traStore = storeDao.getStoreByCode("VP-MainStreet");
    logger.info("The Store is : " + traStore);
  }

  @Test
  public void testUpdateTraStore() throws DaoException {
    TraStore traStore = storeDao.getStoreByCode("VP-MainStreet");
    traStore.setStoreLineNumber("7382651442");
    storeDao.updateStore(traStore);

    traStore = storeDao.getStoreByCode("VP-MainStreet");
    logger.info("The updated store is : " + traStore);
  }

  @Test
  public void testDeleteTraStore() throws DaoException {
    storeDao.deleteStore(3L);
  }
}
