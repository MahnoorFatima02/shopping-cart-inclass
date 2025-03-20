
import org.example.ShoppingCart;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void testAddItem() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(100, 2);
        assertEquals(200, cart.getTotal(), 0.01);
    }

    @Test
    public void testGetTotal() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(30, 4);
        cart.addItem(10, 10);
        assertEquals(220, cart.getTotal(), 0.01);
    }
}