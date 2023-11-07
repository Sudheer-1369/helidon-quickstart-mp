/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.services;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.models.Store;

public interface StoreService {
  Store getStoreById(final long id) throws DaoException;
}
