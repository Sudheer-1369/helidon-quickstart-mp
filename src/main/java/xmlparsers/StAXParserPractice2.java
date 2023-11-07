/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package xmlparsers;

import java.io.ByteArrayInputStream;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

public class StAXParserPractice2 {

  private static final String PAYLOAD = "sudheer";
  //            """
  //            <person>
  //             <name>Sudheer</name>
  //             <g>
  //              <gender/>
  //             </g>
  //             <dob>19970904</dob>
  //            </person>`
  //            """;

  /**
   * 1 - start 2 - end 4 - character
   *
   * @param args
   * @throws XMLStreamException
   */
  public static void main(String[] args) throws XMLStreamException {
    XMLInputFactory factory = XMLInputFactory.newInstance();
    XMLEventReader reader =
        factory.createXMLEventReader(new ByteArrayInputStream(PAYLOAD.getBytes()));

    while (reader.hasNext()) {
      XMLEvent event = reader.nextEvent();

      //            System.out.println(event.getEventType()+"--" + event.getLocation()+" ");

      System.out.println(event.getEventType() + "--" + event.getLocation() + " ");
    }
  }
}
