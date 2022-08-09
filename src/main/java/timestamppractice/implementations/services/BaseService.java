/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package timestamppractice.implementations.services;

public interface BaseService<I, D> {

    D create(D dto);

    D put(D dto);

    D patch(D dto);

    D get(I id);

    void delete(I id);

//    List<D> getAll();

}
