package decoratorTest;

import decorators.Item;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@HelidonTest
public class DecoratorTest {

  private final Item item;

  @Inject
  public DecoratorTest(Item item) {
    this.item = item;
  }

  @Test
  public void testDecorator() {
    item.fetch(1);
  }

  @Test
  public void testDraw() {
    item.draw(0, 1);
  }
}
