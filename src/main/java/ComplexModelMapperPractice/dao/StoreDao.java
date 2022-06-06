/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.dao;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.entities.TraStore;

import java.util.List;

public interface StoreDao {

    public TraStore addStore(TraStore traStore) throws DaoException;

    public TraStore getStoreById(long id) throws DaoException;

    public List<TraStore> getAllTraStores(int page, List<String> params) throws DaoException;

    public TraStore getStoreByCode(String code) throws DaoException;

    public void updateStore(TraStore traStore) throws DaoException;

    public void deleteStore(long id) throws DaoException;

}
