/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package jsonreader;

import javax.json.Json;
import java.io.StringReader;

public class JsonReaderPractice {

    private static final String INPUT_VALUE = "{\n" +
            "  \"eventType\":\"com.oraclecloud.objectstorage.createobject\",\n" +
            "  \"cloudEventsVersion\":\"0.1\",\n" +
            "  \"eventTypeVersion\":\"2.0\",\n" +
            "  \"source\":\"ObjectStorage\",\n" +
            "  \"eventTime\":\"2022-06-17T14:28:51Z\",\n" +
            "  \"contentType\":\"application/json\",\n" +
            "  \"data\":{\n" +
            "    \"compartmentId\":\"ocid1.compartment.oc1..aaaaaaaaeqlrjzpcjmjeku6e2qlqjnotcurkuvcgwtrdcmu3zh3hensrhqra\",\n" +
            "    \"compartmentName\":\"FSGBU-Insurance\",\n" +
            "    \"resourceName\":\"834_6_FunPoc.edi\",\n" +
            "    \"resourceId\":\"/n/idvvfekwvhut/b/DECS_bucket/o/834_6_FunPoc.edi\",\n" +
            "    \"availabilityDomain\":\"PHX-AD-2\",\n" +
            "    \"additionalDetails\":{\n" +
            "      \"bucketName\":\"DECS_bucket\",\n" +
            "      \"versionId\":\"379cff85-039e-4cb2-a7dd-bb8083bdb353\",\n" +
            "      \"archivalState\":\"Available\",\n" +
            "      \"namespace\":\"idvvfekwvhut\",\n" +
            "      \"bucketId\":\"ocid1.bucket.oc1.phx.aaaaaaaaqtrkuil2xzmybuynu4id6s2vw2clhulgnzyspyxrzdlpjl5c4dna\",\n" +
            "      \"eTag\":\"dc6b402a-efe5-41da-922f-7e94722b69fc\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"eventID\":\"e9caba9f-65dc-7d33-f6ba-d9de47ec805c\",\n" +
            "  \"extensions\":{\n" +
            "    \"compartmentId\":\"ocid1.compartment.oc1..aaaaaaaaeqlrjzpcjmjeku6e2qlqjnotcurkuvcgwtrdcmu3zh3hensrhqra\"\n" +
            "  }\n" +
            "}";
    public static void main(String[] args) {

        var jsonReader = Json.createReader(new StringReader(INPUT_VALUE));

        System.out.println(jsonReader);

        var jsonObject = jsonReader.readObject();

        System.out.println(jsonObject);

        var eventType = jsonObject.getString("eventType");

        System.out.println(eventType);

        var data = jsonObject.getJsonObject("data");

        System.out.println(data);
    }
}
