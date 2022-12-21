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

public class StAXParserPractice {

    static String payload = "sudheer";
//            """
//            <person>
//             <name>Sudheer</name>
//             <gender>Male</gender>
//             <dob>19970904</dob>
//            </person>
//            """;

    public static void main(String[] args) throws XMLStreamException {

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader  reader = factory.createXMLEventReader(new ByteArrayInputStream(payload.getBytes()));

        TransactionEntity transaction = new TransactionEntity();

        while(reader.hasNext()){

            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                StartElement startElement = event.asStartElement();
                switch (startElement.getName().getLocalPart()){
                    case "person":
                        System.out.println(event.isStartElement());
                        reader.nextEvent();
                        reader.nextEvent();
                        event = reader.nextEvent();
                        System.out.println(event.asCharacters().getData());
                        reader.nextEvent();
                        reader.nextEvent();
                        reader.nextEvent();
                        event = reader.nextEvent();
                        System.out.println(event.asCharacters().getData());

                        reader.nextEvent();
                        reader.nextEvent();
                        reader.nextEvent();
                        event = reader.nextEvent();

                        System.out.println(event.asCharacters().getData());

//                        if (event.isStartElement()){
//                            System.out.println(event.asStartElement().getName().getLocalPart());
//                        }
//                        if (event.isEndElement()){
//                            System.out.println(event.asEndElement().getName().getLocalPart());
//                        }
//                        transaction.setLastName(event.asCharacters().getData());
//                        System.out.println(transaction);
//                        event = reader.nextEvent();
//                        System.out.println();
//                        transaction.setGender(event.asCharacters().getData());
//                        event = reader.nextEvent();
//                        transaction.setDob(event.asCharacters().getData());
//                        System.out.println(transaction);
                }
            }
        }
    }
}
