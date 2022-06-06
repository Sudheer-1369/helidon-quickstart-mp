package DecoratorTest;

import Decorators.Item;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@HelidonTest
public class DecoratorTest {

    private Item item;

    @Inject
    public DecoratorTest(Item item) {
        this.item = item;
    }

    @Test
    public void testDecorator(){
        item.fetch(1);
    }

    @Test
    public void testDraw(){
        item.draw(0,1);
    }
}
