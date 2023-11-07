/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package complexmodelmapperpractice.services;

import complexmodelmapperpractice.commonexceptions.DaoException;
import complexmodelmapperpractice.models.Store;

public interface StoreService {
  Store getStoreById(final long id) throws DaoException;
}
