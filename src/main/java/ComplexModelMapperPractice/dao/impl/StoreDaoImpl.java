/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.dao.impl;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.dao.StoreDao;
import ComplexModelMapperPractice.entities.TraStore;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ApplicationScoped
public class StoreDaoImpl implements StoreDao {

    private static EntityManagerFactory entityManagerFactory;
    private final int pageSize = 2;
    private EntityManager entityManager;

    {
        entityManagerFactory = Persistence.createEntityManagerFactory("ORCL");
    }

    @Transactional
    public TraStore addStore(TraStore traStore) throws DaoException {

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.persist(traStore);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Exception Occurred while adding the Store " + e.getMessage(), e.getCause());
        } finally {
            entityManager.close();
        }

        return traStore;
    }

    @Transactional
    public TraStore getStoreById(long id) throws DaoException {

        TraStore traStore = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            traStore = entityManager.find(TraStore.class, id);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Exception Occurred while adding the Store", e.getCause());
        } finally {
            entityManager.close();
        }

        return traStore;
    }

    @Transactional
    public List<TraStore> getAllTraStores(int page, List<String> params) throws DaoException {
        List<TraStore> traStoreList = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<TraStore> criteriaQuery = criteriaBuilder.createQuery(TraStore.class);
            Root<TraStore> root = criteriaQuery.from(TraStore.class);

            Predicate predicate = criteriaBuilder.conjunction();


            for (int i = 0; i < params.size(); i++) {
                Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?)");
                Matcher matcher = pattern.matcher(params.get(i));
                while (matcher.find()) {
                    if (matcher.group(2).equals(">")) {
                        predicate = criteriaBuilder.and(predicate, criteriaBuilder.greaterThanOrEqualTo(root.get(matcher.group(1)), matcher.group(3)));
                    } else if (matcher.group(2).equals("<")) {
                        predicate = criteriaBuilder.and(predicate, criteriaBuilder.lessThanOrEqualTo(root.get(matcher.group(1)), matcher.group(3)));
                    } else if (matcher.group(2).equals(":")) {
                        if (matcher.group(1).getClass() == String.class) {
                            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get(matcher.group(1)), "%" + matcher.group(3) + "%"));
                        } else
                            predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(matcher.group(1)), matcher.group(3)));
                    }
                }
            }

            criteriaQuery.where(predicate);
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get("id")));

            TypedQuery<TraStore> typedQuery = entityManager.createQuery(criteriaQuery);
            typedQuery.setFirstResult(page * pageSize);
            typedQuery.setMaxResults(pageSize);
            traStoreList = typedQuery.getResultList();

            /*
            params.stream().forEach(s ->{
                Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
                Matcher matcher = pattern.matcher(s+",");
                while(matcher.find()){
                    if(matcher.group(2).equals(">")){
                        predicate = criteriaBuilder.and(predicate,criteriaBuilder.greaterThanOrEqualTo(root.get(matcher.group(1)),matcher.group(3)));
                    }
                }
            });

             */

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            throw new DaoException("Exception Occurred while retrieving the list of Stores" + e.getMessage(), e.getCause());
        } finally {
            entityManager.close();
        }

        return traStoreList;
    }

    @Transactional
    public TraStore getStoreByCode(String code) throws DaoException {

        TraStore traStore = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            traStore = (TraStore) entityManager.createNativeQuery("SELECT * FROM usersdb.TRA_STORE where CODE = :CODE", TraStore.class).setParameter("CODE", code).getSingleResult();

            traStore = entityManager.find(TraStore.class, traStore.getId());

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Exception Occurred while fetching the Store with code " + e.getMessage(), e.getCause());
        } finally {
            entityManager.close();
        }

        return traStore;
    }

    @Transactional
    public void updateStore(TraStore traStore) throws DaoException {

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            entityManager.merge(traStore);

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Exception Occurred while adding the Store" + e.getMessage(), e.getCause());
        } finally {
            entityManager.close();
        }
    }

    @Transactional
    public void deleteStore(long id) throws DaoException {

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            TraStore traStore = entityManager.find(TraStore.class, id);
            entityManager.remove(traStore);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("Exception Occurred while deleting the Store" + e.getMessage(), e.getCause());
        } finally {
            entityManager.close();
        }
    }
}

