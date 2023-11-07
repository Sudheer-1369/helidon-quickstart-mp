/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.dao;

import static restapis.partialentities.FunctioningCompanies.resultTransformer;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import org.hibernate.query.Query;
import restapis.entities.CompanyEntity;

@ApplicationScoped
public class CompanyDao extends BaseDaoImpl<Long, CompanyEntity> {

  private static final String FUNCTIONING_COMPANY_LIST = "functioningCompanyList";
  private static final String query =
      "select e.company_id as id,e.phone_number as phoneNumber,e.COMPANY_NAME as name from company e";

  public CompanyDao() {
    super(CompanyEntity.class);
  }

  @PostConstruct
  void initialize() {
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

  public List<?> getNewCompanies() throws NoSuchFieldException {
    //        entityManager.getTransaction().begin();
    //
    //        var filter = entityManager.unwrap(Session.class).enableFilter("new-branches");
    //        filter.setParameter("openingDate", Timestamp.valueOf("2029-09-04 10:10:10.0"));

    return findAll();
  }
}
