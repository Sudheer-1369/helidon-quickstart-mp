/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.services;

import restapis.entities.CompanyEntity;
import restapis.implementations.dao.CompanyDao;
import restapis.dto.Company;
import restapis.mappers.CompanyMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CompanyService extends AbstractCrudService<Long, CompanyEntity, Company, CompanyMapper, CompanyDao>{

    @Inject
    public CompanyService(CompanyMapper mapper, CompanyDao dao) {
        super(mapper, dao);
    }
}
