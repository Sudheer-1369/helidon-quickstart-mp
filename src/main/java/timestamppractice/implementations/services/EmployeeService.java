/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package timestamppractice.implementations.services;

import timestamppractice.dto.Employee;
import timestamppractice.entities.EmployeeEntity;
import timestamppractice.implementations.dao.EmployeeDao;
import timestamppractice.mappers.EmployeeMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class EmployeeService extends AbstractCrudService<Long, EmployeeEntity, Employee, EmployeeMapper, EmployeeDao>{

    @Inject
    public EmployeeService(EmployeeMapper mapper, EmployeeDao dao) {
        super(mapper, dao);
    }

}
