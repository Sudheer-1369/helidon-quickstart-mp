/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.mappers;

import restapis.dto.BaseDto;
import restapis.entities.BaseEntity;

import java.util.List;

public interface BaseMapper<E extends BaseEntity<?>, D extends BaseDto<?>> {

    D entityToDto(E dto);

    List<D> entityListToDtoList(List<E> entityList);

    E dtoToEntity(D entity);

    List<E> dtoListToEntityList(List<D> dtoList);

    void merge(E source, E target);

}
