package mapandinstance;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@HelidonTest
class MainTest {

    @Inject
    private Main main;

    @Inject
    private Main2Map main2Map;

    private static final String type = "Instance1";

    @Inject
    MainTest(Main main, Main2Map main2Map){
        this.main = main;
        this.main2Map = main2Map;
    }
    @Test
    void testMainMethod(){

        main.mainMethod();
        main.mainMethod2(type);
    }

    @Test
    void testMain2Method(){
        main2Map.mainMethod2("Instance1");
    }
}
