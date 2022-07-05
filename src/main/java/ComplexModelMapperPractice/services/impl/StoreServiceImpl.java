/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.services.impl;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.dao.StoreDao;
import ComplexModelMapperPractice.entities.TraStore;
import ComplexModelMapperPractice.models.Store;
import ComplexModelMapperPractice.services.StoreService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class StoreServiceImpl implements StoreService {

    @Inject
    private StoreDao storeDao;

    private final ModelMapper mapper = new ModelMapper();

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
