/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package mapstruct.NestedMapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "cdi")
public interface StudentMapper {

  @Mapping(target = "className", source = "classVal")
  @Mapping(target = "author", source = "authorEntity")
  @Mapping(target = "subject.author", source = "subject.author")
  Student getModelFromEntity(StudentEntity studentEntity);

  @Mapping(target = "classVal", source = "className")
  @Mapping(target = "authorEntity", source = "author")
  @Mapping(target = "subject.author", source = "subject.author")
  StudentEntity getEntityFromModel(Student student);

  void merge(StudentEntity studentEntity, @MappingTarget StudentEntity studentEntity1);
}
