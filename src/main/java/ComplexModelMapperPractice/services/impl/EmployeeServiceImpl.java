/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package ComplexModelMapperPractice.services.impl;

import ComplexModelMapperPractice.CommonExceptions.DaoException;
import ComplexModelMapperPractice.dao.EmployeeDao;
import ComplexModelMapperPractice.entities.TraEmployee;
import ComplexModelMapperPractice.models.Employee;
import ComplexModelMapperPractice.services.EmployeeService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeService {

    ModelMapper mapper = new ModelMapper();
    @Inject
    private EmployeeDao employeeDao;

    @Transactional
    public Employee updateEmployee(Employee employee) throws DaoException {
        TraEmployee traEmployee = mapper.map(employee, TraEmployee.class);
        try {
            employeeDao.updateEmployee(traEmployee);
        } catch (Exception e) {
            throw e;
        }

        return mapper.map(traEmployee, Employee.class);
    }
}
