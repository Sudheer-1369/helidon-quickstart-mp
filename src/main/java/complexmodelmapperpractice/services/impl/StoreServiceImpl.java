/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.services.impl;

import complexmodelmapperpractice.commonexceptions.DaoException;
import complexmodelmapperpractice.dao.StoreDao;
import complexmodelmapperpractice.entities.TraStore;
import complexmodelmapperpractice.models.Store;
import complexmodelmapperpractice.services.StoreService;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class StoreServiceImpl implements StoreService {

  private final ModelMapper mapper = new ModelMapper();
  @Inject private StoreDao storeDao;

  public Store getStoreById(final long id) throws DaoException {
    TraStore traStore = null;
    try {
      traStore = storeDao.getStoreById(id);
    } catch (DaoException e) {
      throw e;
    }
    return mapper.map(traStore, Store.class);
  }
}
