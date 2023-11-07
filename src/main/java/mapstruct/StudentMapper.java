/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package mapstruct;

import java.nio.charset.StandardCharsets;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface StudentMapper {

  @Mapping(target = "name", source = "studentName", defaultValue = "Sudheer")
  @Mapping(target = "phnNo", expression = "java(getBytesFromPhnNoString(student.getPhnNo()))")
  StudentsEntity entityToModel(Student student);

  @Mapping(target = "studentName", source = "name", defaultValue = "sudheer")
  @Mapping(target = "phnNo", expression = "java(getStringPhnNoFromBytes(studentEntity.getPhnNo()))")
  @Mapping(target = "fee", constant = "2000")
  Student modelToEntity(StudentsEntity studentEntity);

  default String getStringPhnNoFromBytes(byte[] bytes) {

    String phnNo = new String(bytes, StandardCharsets.UTF_8);
    return phnNo;
  }

  default byte[] getBytesFromPhnNoString(String phnNo) {

    return phnNo.getBytes(StandardCharsets.UTF_8);
  }
}
