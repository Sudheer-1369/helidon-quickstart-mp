/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package inputStreamPractice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class InputStreamPractice {

    public static void main(String[] args) throws IOException {
        String payload = "Hello Mounika, Sudheer Loves you";

        System.out.println(payload.length());

        InputStream stream = new ByteArrayInputStream(payload.getBytes());

        byte[] bytes = new byte[50];

        var size = stream.read(bytes);

        if(size <1000){
            byte[] newBytes = Arrays.copyOfRange(bytes,0,size);
            System.out.println(new String(newBytes, StandardCharsets.UTF_8));
        }
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        stream.close();
    }
}
