package beaninjection;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;
import org.testcontainers.shaded.org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@HelidonTest
public class FileReader {

    @Test
    public void readFile() throws IOException {
        String fileName = "src/test/resources/SampleFile";

        String content = FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);

        System.out.println(content);
    }
}
