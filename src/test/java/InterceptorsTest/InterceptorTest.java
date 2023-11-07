package InterceptorsTest;

import Interceptors.InterceptorCheck;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@HelidonTest
public class InterceptorTest {

  @Inject private InterceptorCheck interceptorCheck;

  @Test
  public void testInterceptor() throws Exception {

    interceptorCheck.divide(1, 0);
  }
}
