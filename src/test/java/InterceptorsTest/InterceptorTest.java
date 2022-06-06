package InterceptorsTest;

import Interceptors.InterceptorCheck;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@HelidonTest
public class InterceptorTest {

    @Inject
    private InterceptorCheck interceptorCheck;

    @Test
    public void testInterceptor() throws Exception {

        interceptorCheck.divide(1,0);
    }
}
