/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.dao;

import complexmodelmapperpractice.commonexceptions.DaoException;
import complexmodelmapperpractice.entities.TraStore;
import java.util.List;

public interface StoreDao {

  TraStore addStore(TraStore traStore) throws DaoException;

  TraStore getStoreById(long id) throws DaoException;

  List<TraStore> getAllTraStores(int page, List<String> params) throws DaoException;

  TraStore getStoreByCode(String code) throws DaoException;

  void updateStore(TraStore traStore) throws DaoException;

  void deleteStore(long id) throws DaoException;
}
