/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.services;

import restapis.dto.BaseDto;
import restapis.entities.BaseEntity;
import restapis.implementations.dao.BaseDao;
import restapis.mappers.BaseMapper;

import javax.transaction.Transactional;
import java.io.Serializable;


public abstract class AbstractCrudService
        <I extends Serializable,
                E extends BaseEntity<I>,
                D extends BaseDto<I>,
                M extends BaseMapper<E, D>,
                T extends BaseDao<I, E>>
        implements BaseService<I, D> {

    protected final M mapper;
    protected final T dao;

    protected AbstractCrudService(M mapper, T dao) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Transactional
    public D create(D dto) {

        E entity = mapper.dtoToEntity(dto);
        E persistedEntity = dao.create(entity);

        return mapper.entityToDto(persistedEntity);
    }

    @Transactional
    public D put(D dto) {

        E entity = mapper.dtoToEntity(dto);
        E updatedEntity = dao.update(entity);

        return mapper.entityToDto(updatedEntity);

    }

    @Transactional
    public D patch(D dto) {

        I id = dto.getId();
        E sourceEntity = mapper.dtoToEntity(dto);
        E targetEntity = dao.findById(id);

        if (targetEntity == null)
            return null;

        mapper.merge(sourceEntity, targetEntity);

        return mapper.entityToDto(dao.update(targetEntity));
    }

    public D get(I id) {

        E entity = dao.findById(id);

        if (entity == null)
            return null;

        return mapper.entityToDto(entity);

    }

    @Transactional
    public void delete(I id) {

        dao.deleteById(id);
    }

}
