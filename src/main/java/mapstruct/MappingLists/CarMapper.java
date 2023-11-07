/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package mapstruct.MappingLists;

import java.util.List;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = {UUID.class, String.class})
public interface CarMapper {

  //    @Mapping(target = "carBrand", source = "brand", defaultValue = "BMW")
  List<Car> getCarListFromEntityList(List<CarEntity> carEntityList);

  @Mapping(target = "carBrand", source = "brand", defaultValue = "BMW")
  Car getCarModelFromEntity(CarEntity carEntity);
}
