/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package xmlparsers;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.ByteArrayInputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class StAXParser {

    public static void main(String[] args) throws XMLStreamException, ParseException {
        XMLInputFactory factory = XMLInputFactory.newInstance();


        String testString = """
<decsTransaction xmlns="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/ProcessPayloadBO">
   <nsmpr12:person xmlns:nsmpr12="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DECSTransactionBO">
      <nsmpr4:birthDate xmlns:nsmpr4="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/PersonBO">
         <nsmpr29:value xmlns:nsmpr29="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DateComplexType">19630101</nsmpr29:value>
         <nsmpr29:format xmlns:nsmpr29="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DateComplexType">YYYYMMDD</nsmpr29:format>
      </nsmpr4:birthDate>
      <nsmpr4:gender xmlns:nsmpr4="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/PersonBO">X</nsmpr4:gender>
      <nsmpr4:subscriberID xmlns:nsmpr4="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/PersonBO">546441234</nsmpr4:subscriberID>
      <nsmpr4:memberSSN xmlns:nsmpr4="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/PersonBO">546441234</nsmpr4:memberSSN>
      <nsmpr4:memberInfo xmlns:nsmpr4="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/PersonBO">
         <ns20:memberleveldatedetails xmlns:ns20="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/MemberInfoBO">
            <nsmpr37:employmentStartDate xmlns:nsmpr37="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/MemberleveldatedetailsBO">
               <nsmpr29:value xmlns:nsmpr29="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DateComplexType">20201201</nsmpr29:value>
               <nsmpr29:format xmlns:nsmpr29="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DateComplexType">YYYYMMDD</nsmpr29:format>
            </nsmpr37:employmentStartDate>
         </ns20:memberleveldatedetails>
         <ns20:coverages xmlns:ns20="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/MemberInfoBO">
            <nsmpr15:coverage xmlns:nsmpr15="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/CoveragesBO">
               <nsmpr8:planTypeCode xmlns:nsmpr8="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/CoverageBO">HLT</nsmpr8:planTypeCode>
               <nsmpr8:coverageDates xmlns:nsmpr8="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/CoverageBO">
                  <nsmpr41:startDate xmlns:nsmpr41="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/CoverageDatesBO">
                     <nsmpr29:value xmlns:nsmpr29="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DateComplexType">20210101</nsmpr29:value>
                     <nsmpr29:format xmlns:nsmpr29="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DateComplexType">YYYYMMDD</nsmpr29:format>
                  </nsmpr41:startDate>
               </nsmpr8:coverageDates>
            </nsmpr15:coverage>
            <nsmpr15:coverage xmlns:nsmpr15="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/CoveragesBO">
               <nsmpr8:planTypeCode xmlns:nsmpr8="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/CoverageBO">DEN</nsmpr8:planTypeCode>
               <nsmpr8:coverageDates xmlns:nsmpr8="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/CoverageBO">
                  <nsmpr41:startDate xmlns:nsmpr41="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/CoverageDatesBO">
                     <nsmpr29:value xmlns:nsmpr29="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DateComplexType">20210101</nsmpr29:value>
                     <nsmpr29:format xmlns:nsmpr29="http://xmlns.oracle.com/bpm/bpmobject/BusinessData/DateComplexType">YYYYMMDD</nsmpr29:format>
                  </nsmpr41:startDate>
               </nsmpr8:coverageDates>
            </nsmpr15:coverage>
         </ns20:coverages>
      </nsmpr4:memberInfo>
   </nsmpr12:person>
</decsTransaction>                """;

        XMLEventReader eventReader = factory.createXMLEventReader(new ByteArrayInputStream(testString.getBytes()));

        TransactionEntity transaction = new TransactionEntity();

        String format;
        String date;

        boolean personFlag = false;
        boolean activityFlag = false;

        while (eventReader.hasNext()) {
            XMLEvent nextEvent = eventReader.nextEvent();

            if (personFlag && activityFlag)
                break;

            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();

                switch (startElement.getName().getLocalPart()) {
                    case "gender":
                        nextEvent = returnDataEvent(eventReader, nextEvent);
                        transaction.setGender(nextEvent.asCharacters().getData());
                        break;
                    case "lastName":
                        nextEvent = returnDataEvent(eventReader, nextEvent);
                        transaction.setLastName(nextEvent.asCharacters().getData());
                        break;
                    case "birthDate":
                        nextEvent = returnDataEvent(eventReader, eventReader.nextEvent());
                        date = nextEvent.asCharacters().getData();
                        System.out.println(date);

                        nextEvent = returnDataEvent(eventReader, nextEvent);
                        format = nextEvent.asCharacters().getData();
                        System.out.println(format);
                        transaction.setDateOfBirth(new Date(new SimpleDateFormat(format).parse(date).getDate()));
                        break;
                    case "actionCode":
                        nextEvent = returnDataEvent(eventReader, nextEvent);
                        transaction.setDob(nextEvent.asCharacters().getData());
                }
            }
            if (nextEvent.isEndElement()){
                if (nextEvent.asEndElement().getName().getLocalPart().equalsIgnoreCase("person"))
                    personFlag = true;
                if (nextEvent.asEndElement().getName().getLocalPart().equalsIgnoreCase("activity"))
                    activityFlag = true;
            }
        }

        System.out.println(transaction);
    }

    public static XMLEvent returnDataEvent(XMLEventReader reader, XMLEvent event) throws XMLStreamException {

        while (!event.isStartElement())
            event = reader.nextEvent();

        return reader.nextEvent();
    }

}
