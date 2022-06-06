/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package MapStruct.MappingMapAndStream;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;

import java.util.GregorianCalendar;
import java.util.Map;
import java.util.stream.Stream;

@Mapper
public interface UtilityMapper {
    @MapMapping(valueDateFormat = "dd.MM.yyyy")
    Map<String, String> getMap(Map<Long, GregorianCalendar> source);

    Stream<String> getStream(Stream<Integer> source);
}
