/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.dao;

import org.hibernate.Session;
import restapis.entities.BaseEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.validation.Valid;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public abstract class BaseDaoImpl<I extends Serializable, E extends BaseEntity<I>> implements BaseDao<I, E> {

    public static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("DECS");
    }

    private final Class<E> entityType;
    protected EntityManager entityManager;

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

        E responseEntity = entityManager.find(entityType, id);

        entityManager.close();

        return responseEntity;
    }

    @Override
    public void deleteById(I id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.remove(entityManager.getReference(entityType, id));
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<E> findAll() throws NoSuchFieldException {

        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        var filter = entityManager.unwrap(Session.class).enableFilter("newbranches");
        filter.setParameter("openingDate", Timestamp.valueOf("2020-09-04 10:10:10.0"));

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(entityType);
        Root<E> root = cq.from(entityType);

        cq.select(root);

        var list =  entityManager.createQuery(cq).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        return list;
    }

}
