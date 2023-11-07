/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package restapis.mappers;

import java.util.List;
import org.mapstruct.*;
import restapis.dto.Company;
import restapis.entities.CompanyEntity;

@Mapper(componentModel = "cdi")
public interface CompanyMapper extends BaseMapper<CompanyEntity, Company> {

  @Mapping(target = "employees[].joiningDate", ignore = true)
  Company entityToDto(CompanyEntity entity);

  List<Company> entityListToDtoList(List<CompanyEntity> entityList);

  @Mapping(target = "employees[].joiningDate", ignore = true)
  CompanyEntity dtoToEntity(Company dto);

  List<CompanyEntity> dtoListToEntityList(List<Company> dtoList);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void merge(CompanyEntity source, @MappingTarget CompanyEntity target);
}
