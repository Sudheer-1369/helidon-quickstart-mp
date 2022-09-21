/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.dao;

import javax.validation.Valid;

public interface BaseDao<I, E> {

    E create(@Valid E entity);

    E update(@Valid E entity);

    E findById(I id);

    void deleteById(I id);

//    List<E> findAll(int page);

}
