package restapispractice.restapi;

import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;
import restapis.runtimesupport.test.JsonContextParameterResolver;

import javax.inject.Inject;
import javax.ws.rs.client.WebTarget;

@HelidonTest
public class MyResourceTest {

    private WebTarget target;

    @Inject
    public MyResourceTest(WebTarget target) {
        this.target = target;
    }

    @Test
    void testMyResourceJersey(JsonContextParameterResolver.JSONContext context)  {
        try(var r = target.path("myresource").path("").request().get()){
            System.out.println(context.top(r));
        }
    }
}
