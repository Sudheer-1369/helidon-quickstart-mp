/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package timestamppractice.implementations.dao;

import timestamppractice.entities.CompanyEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CompanyDao extends BaseDaoImpl<Long, CompanyEntity> {

    public CompanyDao() {
        super(CompanyEntity.class);
    }

}
