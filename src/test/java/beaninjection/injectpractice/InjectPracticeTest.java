package beaninjection.injectpractice;

import beaninjectionpractice.injectpractice.InjectPractice;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@HelidonTest
class InjectPracticeTest {

  private final InjectPractice injectPractice;

  @Inject
  InjectPracticeTest(InjectPractice injectPractice) {
    this.injectPractice = injectPractice;
  }

  @Test
  void testInjectPractice() {
    injectPractice.testType();
  }
}
