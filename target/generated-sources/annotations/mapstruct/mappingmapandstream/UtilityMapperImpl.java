package mapstruct.mappingmapandstream;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.processing.Generated;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-07T21:00:17+0530",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
public class UtilityMapperImpl implements UtilityMapper {

    private final DatatypeFactory datatypeFactory;

    public UtilityMapperImpl() {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        }
        catch ( DatatypeConfigurationException ex ) {
            throw new RuntimeException( ex );
        }
    }

    @Override
    public Map<String, String> getMap(Map<Long, GregorianCalendar> source) {
        if ( source == null ) {
            return null;
        }

        Map<String, String> map = new HashMap<String, String>( Math.max( (int) ( source.size() / .75f ) + 1, 16 ) );

        for ( java.util.Map.Entry<Long, GregorianCalendar> entry : source.entrySet() ) {
            String key = new DecimalFormat( "" ).format( entry.getKey() );
            String value = xmlGregorianCalendarToString( calendarToXmlGregorianCalendar( entry.getValue() ), "dd.MM.yyyy" );
            map.put( key, value );
        }

        return map;
    }

    @Override
    public Stream<String> getStream(Stream<Integer> source) {
        if ( source == null ) {
            return null;
        }

        return source.map( integer -> String.valueOf( integer ) );
    }

    private String xmlGregorianCalendarToString( XMLGregorianCalendar xcal, String dateFormat ) {
        if ( xcal == null ) {
            return null;
        }

        if (dateFormat == null ) {
            return xcal.toString();
        }
        else {
            Date d = xcal.toGregorianCalendar().getTime();
            SimpleDateFormat sdf = new SimpleDateFormat( dateFormat );
            return sdf.format( d );
        }
    }

    private XMLGregorianCalendar calendarToXmlGregorianCalendar( Calendar cal ) {
        if ( cal == null ) {
            return null;
        }

        GregorianCalendar gcal = new GregorianCalendar( cal.getTimeZone() );
        gcal.setTimeInMillis( cal.getTimeInMillis() );
        return datatypeFactory.newXMLGregorianCalendar( gcal );
    }
}
