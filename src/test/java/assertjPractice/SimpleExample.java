package assertjPractice;

import static org.assertj.core.api.Assertions.assertThat;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import java.math.BigInteger;
import java.util.function.Consumer;
import org.assertj.core.api.Assertions;
import org.assertj.core.description.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@HelidonTest
public class SimpleExample {

  @Test
  @DisplayName(
      "Should check if the passed string starts and ends with the provided strings/characters")
  void simpleTest() {

    assertThat("The Lord of Rings")
        .isNotNull()
        .startsWithIgnoringCase("the")
        .endsWith("Rings")
        .contains("Lord")
        .containsAnyOf("Lord", "of");
  }

  @Test
  @DisplayName("When asserting should check&request for the same datatype ")
  void testBasedOnDataType() {
    BigInteger bigInteger = new BigInteger("123342");
    assertThat(bigInteger).isGreaterThan(new BigInteger("20000"));
  }

  @Test
  @DisplayName("Should be able to add a description in case of an error")
  void testAddDescriptionIncaseOfError() {
    String str = "Sudheer";
    assertThat(str).as("Check if the name is %s or not : ", str).isEqualTo("Sudheer");
  }

  @Test
  @DisplayName("Should be able to get the description while asserting")
  void testGetDescription() {
    //        Assertions.setPrintAssertionsDescription(true);

    StringBuilder sb = new StringBuilder(String.format("Assertions:%n"));
    Consumer<Description> descriptor =
        description -> {
          sb.append(String.format("--%s%n", description));
        };

    Assertions.setDescriptionConsumer(descriptor);
    BigInteger bigInteger = new BigInteger("123342");
    assertThat(bigInteger).as("Checking the bigInteger").isGreaterThan(new BigInteger("20000"));
    System.out.println(sb);
  }

  @Test
  @DisplayName("Overriding an error message")
  void testOverrideError() {
    String str = "Sudheer";
    assertThat(str).withFailMessage("The name should be %s", str).isEqualTo("Sudheer");
  }
}
