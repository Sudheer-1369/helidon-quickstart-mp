package InterceptorsTest;

import InterceptorForThreads.InterceptorChecking;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@HelidonTest
public class AroundThreadTest {

    @Inject
    private InterceptorChecking checking;

    @Test
    public void testDivide() {

        checking.divide();
    }

}
