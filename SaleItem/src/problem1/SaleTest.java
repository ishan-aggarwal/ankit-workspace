package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SaleTest {
    Sale sale = new Sale();

    @Before
    public void setup() {
        Item item = new Item("Television", 200, 2);
        sale.addItem(item);
    }

    @Test
    public void testGetDiscount() {
        double discount = sale.getDiscount();
        Assert.assertEquals(20.0, discount, 0);
    }

    @Test
    public void testGetSubTotal() {
        double subTotal = sale.getSubTotal();
        Assert.assertEquals(400.0, subTotal, 0);
    }

    @Test
    public void testGetDiscountedSubTotal () {
        double discountedSubTotal = sale.getDiscountedSubTotal();
        Assert.assertEquals(380.0, discountedSubTotal, 0);
    }

}
