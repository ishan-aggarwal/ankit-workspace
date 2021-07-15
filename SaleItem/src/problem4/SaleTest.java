package problem4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

public class SaleTest {
    Sale sale = new Sale(new PreferredCustomer());

    @Before
    public void setup() {
        Item item = new Item("Television", 200, 2);
        sale.addItem(item);
    }

    @Test
    public void testSeniorDiscountOnThursday() {
        Customer customer = new SeniorCustomer();
        Sale sale1 = new Sale(customer);
        Item item1 = new Item("Television", 200, 2);
        sale1.addItem(item1);
        Calendar instance = Calendar.getInstance();
        boolean isTuesday = Calendar.TUESDAY == instance.get(Calendar.DAY_OF_WEEK);
        System.out.println("Today is tuesday: "+isTuesday);
        if(isTuesday) {
            Assert.assertEquals( .15 ,sale1.getDiscountRate(), 0);
        } else {
            Assert.assertEquals( 0.05 ,sale1.getDiscountRate(), 0);
        }
    }



    @Test
    public void testGetDiscount() {
        double discount = sale.getDiscount();
        Assert.assertEquals(80.0, discount, 0);
    }

    @Test
    public void testGetSubTotal() {
        double subTotal = sale.getSubTotal();
        Assert.assertEquals(400.0, subTotal, 0);
    }

    @Test
    public void testGetDiscountedSubTotal () {
        double discountedSubTotal = sale.getDiscountedSubTotal();
        Assert.assertEquals(320.0, discountedSubTotal, 0);
    }

    @Test
    public void testGetDiscountRate() {
        double discountRate = sale.getDiscountRate();
        Assert.assertEquals(.20 , discountRate, 0);
    }

}
