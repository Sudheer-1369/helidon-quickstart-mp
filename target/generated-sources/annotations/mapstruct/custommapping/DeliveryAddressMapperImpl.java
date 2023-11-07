package mapstruct.custommapping;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T21:00:16+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class DeliveryAddressMapperImpl implements DeliveryAddressMapper {

    @Override
    public DeliveryAddress deliveryAddressFromAddressAndStudent(AddressEntity addressEntity, StudentEntity studentEntity) {
        if ( addressEntity == null && studentEntity == null ) {
            return null;
        }

        DeliveryAddress deliveryAddress = new DeliveryAddress();

        if ( addressEntity != null ) {
            deliveryAddress.setHouseNumber( addressEntity.getHouseNo() );
            deliveryAddress.setCity( addressEntity.getCity() );
            deliveryAddress.setState( addressEntity.getState() );
        }
        if ( studentEntity != null ) {
            deliveryAddress.setStudentName( studentEntity.getName() );
            if ( studentEntity.getId() != null ) {
                deliveryAddress.setId( Integer.parseInt( studentEntity.getId() ) );
            }
            deliveryAddress.setName( studentEntity.getName() );
        }

        return deliveryAddress;
    }

    @Override
    public StudentEntity studentFromDeliveryAddress(DeliveryAddress deliveryAddress) {
        if ( deliveryAddress == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setName( deliveryAddress.getStudentName() );
        studentEntity.setId( String.valueOf( deliveryAddress.getId() ) );

        return studentEntity;
    }
}
