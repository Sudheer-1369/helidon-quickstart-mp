package beaninjection.injectpractice;

import beaninjectionpractice.injectpractice.InjectPractice;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@HelidonTest
class InjectPracticeTest {

    private final InjectPractice injectPractice;
    @Inject
    InjectPracticeTest(InjectPractice injectPractice){
        this.injectPractice = injectPractice;
    }

    @Test
    void testInjectPractice(){
        injectPractice.testType();
    }
}
