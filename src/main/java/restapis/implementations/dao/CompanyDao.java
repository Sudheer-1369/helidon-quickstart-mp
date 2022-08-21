/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.dao;

import restapis.entities.CompanyEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyDao extends BaseDaoImpl<Long, CompanyEntity> {

    public CompanyDao() {
        super(CompanyEntity.class);
    }

//    @Override
//    public List<CompanyEntity> findAll() throws NoSuchFieldException {
//
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<CompanyEntity> cq = cb.createQuery(CompanyEntity.class);
//        Root<CompanyEntity> root = cq.from(CompanyEntity.class);
//
//        Predicate predicate = cb.equal(root.get("phoneNumber"),"Sudheer");
//
////        cq.select()
//        cq.where(predicate);
//
//        TypedQuery<CompanyEntity> tq = entityManager.createQuery(cq);
//
//        List<CompanyEntity> companyEntities = tq.getResultList();
//
//        return companyEntities;
//    }

}
