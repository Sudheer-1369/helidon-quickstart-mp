/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.services.impl;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.dao.StoreDao;
import ComplexModelMapperPractice.entities.TraStore;
import ComplexModelMapperPractice.models.Store;
import ComplexModelMapperPractice.services.StoreService;
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
