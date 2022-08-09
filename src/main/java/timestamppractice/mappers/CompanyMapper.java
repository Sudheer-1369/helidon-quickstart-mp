/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package timestamppractice.mappers;

import org.mapstruct.*;
import timestamppractice.dto.Company;
import timestamppractice.entities.CompanyEntity;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface CompanyMapper extends BaseMapper<CompanyEntity, Company> {

    @Mapping(target = "employees[].joiningDate", ignore = true)
    Company entityToDto(CompanyEntity entity);

    List<Company> entityListToDtoList(List<CompanyEntity> entityList);

    @Mapping(target = "employees[].joiningDate", ignore = true)
    CompanyEntity dtoToEntity(Company dto);

    List<CompanyEntity> dtoListToEntityList(List<Company> dtoList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void merge(CompanyEntity source,@MappingTarget CompanyEntity target);

}
