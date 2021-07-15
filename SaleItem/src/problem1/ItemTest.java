package problem1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    Item item;

    @Before
    public void setup() {
        item = new Item("Television", 200, 2);
    }

    @Test
    public void testGetItemTotal() {
        double itemTotal = item.getItemTotal();
        Assert.assertEquals(400.0, itemTotal, 0);
    }

}
