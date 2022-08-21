/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.implementations.dao;

import restapis.entities.EmployeeEntity;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeDao extends BaseDaoImpl<Long, EmployeeEntity> {

    public EmployeeDao() {
        super(EmployeeEntity.class);
    }
}
