package charlene.coffee.corner.management;

import charlene.coffe.corner.data.MenuItemTemplate;
import charlene.coffe.corner.data.menu.items.MenuItem;
import charlene.coffe.corner.management.Basket;
import charlene.coffe.corner.management.BasketItem;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BasketTest {


    @Test
    public void addNullTest() {
        Basket basket = new Basket();
        basket.add(null);
        Assert.assertEquals(0,basket.getItems().size());

    }

    @Test
    public void addLargeCoffee() {
        Basket basket = new Basket();
        basket.add(MenuItemTemplate.LARGE_COFFEE.create());

        Assert.assertEquals(1,basket.getItems().size());
        Assert.assertEquals(1,basket.getItems().get(0).getCount());
        Assert.assertEquals(MenuItemTemplate.LARGE_COFFEE.create().getTitle(),basket.getItems().get(0).getMenuItem().getTitle());

    }

    @Test
    public void removeLargeCoffee() {
        Basket basket = new Basket();
        basket.add(MenuItemTemplate.LARGE_COFFEE.create());
        basket.remove(MenuItemTemplate.LARGE_COFFEE.create());

        Assert.assertEquals(0,basket.getItems().size());
    }

    @Test
    public void totalPrice2SameItemsTest() {
        Basket basket = new Basket();
        basket.add(MenuItemTemplate.LARGE_COFFEE.create());
        basket.add(MenuItemTemplate.LARGE_COFFEE.create());
        Assert.assertEquals(BigDecimal.valueOf(7).setScale(2), basket.totalPrice());
    }



}
