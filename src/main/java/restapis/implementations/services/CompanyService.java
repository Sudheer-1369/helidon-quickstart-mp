/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.services;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import restapis.dto.Company;
import restapis.entities.CompanyEntity;
import restapis.implementations.dao.CompanyDao;
import restapis.mappers.CompanyMapper;

@ApplicationScoped
public class CompanyService
    extends AbstractCrudService<Long, CompanyEntity, Company, CompanyMapper, CompanyDao> {

  @Inject
  public CompanyService(CompanyMapper mapper, CompanyDao dao) {
    super(mapper, dao);
  }

  public List<?> getFew() {

    return dao.getFew();
  }
}
