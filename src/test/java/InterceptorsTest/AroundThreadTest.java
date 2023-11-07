package InterceptorsTest;

import interceptorforthreads.InterceptorChecking;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@HelidonTest
public class AroundThreadTest {

  @Inject private InterceptorChecking checking;

  @Test
  public void testDivide() {

    //        checking.divide();
  }
}
