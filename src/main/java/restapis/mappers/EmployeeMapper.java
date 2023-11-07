/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.mappers;

import java.util.List;
import org.mapstruct.*;
import restapis.dto.Employee;
import restapis.entities.EmployeeEntity;

@Mapper(componentModel = "cdi")
public interface EmployeeMapper extends BaseMapper<EmployeeEntity, Employee> {

  @Mapping(target = "joiningDate", ignore = true)
  Employee entityToDto(EmployeeEntity entity);

  List<Employee> entityListToDtoList(List<EmployeeEntity> entityList);

  @Mapping(target = "joiningDate", ignore = true)
  EmployeeEntity dtoToEntity(Employee dto);

  List<EmployeeEntity> dtoListToEntityList(List<Employee> dtoList);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void merge(EmployeeEntity source, @MappingTarget EmployeeEntity target);
}
