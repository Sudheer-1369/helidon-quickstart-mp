/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package timestamppractice.implementations.services;

import timestamppractice.dto.Company;
import timestamppractice.entities.CompanyEntity;
import timestamppractice.implementations.dao.CompanyDao;
import timestamppractice.mappers.CompanyMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CompanyService extends AbstractCrudService<Long, CompanyEntity, Company, CompanyMapper, CompanyDao>{

    @Inject
    public CompanyService(CompanyMapper mapper, CompanyDao dao) {
        super(mapper, dao);
    }
}
