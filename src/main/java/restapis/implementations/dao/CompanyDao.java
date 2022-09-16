/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.dao;

import org.hibernate.query.Query;
import restapis.entities.CompanyEntity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.List;

import static restapis.partialentities.FunctioningCompanies.resultTransformer;

@ApplicationScoped
public class CompanyDao extends BaseDaoImpl<Long, CompanyEntity> {

    private static final String FUNCTIONING_COMPANY_LIST = "functioningCompanyList";
    private static final String query = "select e.company_id as id,e.phone_number as phoneNumber,e.COMPANY_NAME as name from company e";

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

    public CompanyDao() {
        super(CompanyEntity.class);
    }

    @PostConstruct
    void intialize() {
        entityManager = entityManagerFactory.createEntityManager();
        var nativeQuery = entityManager.createNativeQuery(query);
        entityManager.getEntityManagerFactory().addNamedQuery(FUNCTIONING_COMPANY_LIST, nativeQuery);

    }

    public List<?> getFew() {

//        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        return entityManager
                .createNamedQuery(FUNCTIONING_COMPANY_LIST)
                .unwrap(Query.class)
                .setResultTransformer(resultTransformer)
                .getResultList();
    }


}
