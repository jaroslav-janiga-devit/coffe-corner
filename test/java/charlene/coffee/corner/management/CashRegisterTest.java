package charlene.coffee.corner.management;


import charlene.ResourceReaderUtil;
import charlene.coffe.corner.data.MenuItemTemplate;
import charlene.coffe.corner.management.CashRegister;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class CashRegisterTest {

    @Test
    public void addAllMenuItemsTest() throws IOException {
        String expectedReceipt = ResourceReaderUtil.readReceipt("receipts/receipt-all-items");
        CashRegister cashRegister = new CashRegister();
        Arrays.stream(MenuItemTemplate.values())
                .map(MenuItemTemplate::create)
                .forEach(cashRegister::addMenuItem);
        String currentResult = cashRegister.printReceipt();
        Assert.assertEquals(expectedReceipt, currentResult);
    }


    @Test
    public void tripleItemTest() throws IOException {
        String expectedReceipt = ResourceReaderUtil.readReceipt("receipts/receipt-triple-item");
        CashRegister cashRegister = new CashRegister();
        cashRegister.addMenuItem(MenuItemTemplate.LARGE_COFFEE.create());
        cashRegister.addMenuItem(MenuItemTemplate.LARGE_COFFEE.create());
        cashRegister.addMenuItem(MenuItemTemplate.LARGE_COFFEE.create());
        String currentResult = cashRegister.printReceipt();
        Assert.assertEquals(expectedReceipt, currentResult);
    }


}
