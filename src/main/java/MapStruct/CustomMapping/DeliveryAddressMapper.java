/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MapStruct.CustomMapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DeliveryAddressMapper {

    @Mapping(target = "houseNumber", source = "addressEntity.houseNo")
    @Mapping(target = "studentName", source = "studentEntity.name")
    DeliveryAddress deliveryAddressFromAddressAndStudent(AddressEntity addressEntity, StudentEntity studentEntity);

    @Mapping(target = "name", source = "studentName")
    StudentEntity studentFromDeliveryAddress(DeliveryAddress deliveryAddress);

}
