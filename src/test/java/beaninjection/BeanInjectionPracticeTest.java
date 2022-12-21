package beaninjection;

import beaninjectionpractice.BeanInjection;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@HelidonTest
public class BeanInjectionPracticeTest {

    @Inject
    private BeanInjection beanInjection;

    /**
     * This will throw an exception stating ambiguos because we have two classes implementing same interface and it cannot decide which
     * implementing class to inject in such cases we should not use the interface for the injection use the implementing class for injection
     */
    @Test
    public void testBeanInjection() {
        beanInjection.addBean();
    }
}
