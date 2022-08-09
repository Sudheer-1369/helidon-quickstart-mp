/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package timestamppractice.implementations.dao;

import timestamppractice.entities.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.Valid;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoImpl<I extends Serializable, E extends BaseEntity<I>> implements BaseDao<I, E> {

    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("DECS");
    }


    private EntityManager entityManager;

    private final Class<E> entityType;

    public BaseDaoImpl(Class<E> entityType) {
        this.entityType = entityType;
    }


    @Override
    public E create(@Valid E entity) {

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        entityManager.close();

        return entity;

    }

    @Override
    public E update(@Valid E entity) {

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        E responseEntity = entityManager.merge(entity);
        entityManager.getTransaction().commit();

        entityManager.close();

        return responseEntity;

    }

    @Override
    public E findById(I id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        E responseEntity =  entityManager.find(entityType, id);

        entityManager.close();

        return responseEntity;
    }

    @Override
    public void deleteById(I id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.getReference(entityType,id));
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    /**
     * TODO Include the param page.
     * @return
     */
    public List<E> findAll() {

        return new ArrayList<>();
    }

}
