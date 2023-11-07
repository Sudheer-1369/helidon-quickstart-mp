package mapstruct.mappinglists;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T21:00:17+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class CarMapperImpl implements CarMapper {

    @Override
    public List<Car> getCarListFromEntityList(List<CarEntity> carEntityList) {
        if ( carEntityList == null ) {
            return null;
        }

        List<Car> list = new ArrayList<Car>( carEntityList.size() );
        for ( CarEntity carEntity : carEntityList ) {
            list.add( getCarModelFromEntity( carEntity ) );
        }

        return list;
    }

    @Override
    public Car getCarModelFromEntity(CarEntity carEntity) {
        if ( carEntity == null ) {
            return null;
        }

        Car car = new Car();

        if ( carEntity.getBrand() != null ) {
            car.setCarBrand( carEntity.getBrand() );
        }
        else {
            car.setCarBrand( "BMW" );
        }
        car.setId( carEntity.getId() );
        car.setPrice( carEntity.getPrice() );
        car.setManufacturingDate( carEntity.getManufacturingDate() );
        car.setName( carEntity.getName() );

        return car;
    }
}
