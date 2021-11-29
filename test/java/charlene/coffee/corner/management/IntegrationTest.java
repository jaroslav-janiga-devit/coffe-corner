package charlene.coffee.corner.management;

import charlene.ResourceReaderUtil;
import charlene.coffe.corner.management.CashRegister;
import charlene.coffe.corner.utils.parser.InputParser;
import org.junit.Assert;
import org.junit.Test;

public class IntegrationTest {

    @Test
    public void inputFromAssignmentTest() {
        String input = "large coffee with extra milk, small coffee with special roast, bacon roll, orange juice";
        String expectedReceipt = ResourceReaderUtil.readReceipt("receipts/integration-assignment-receipt");
                CashRegister cashRegister = new CashRegister();
        InputParser.parseInputItems(input)
                .forEach(cashRegister::addMenuItem);
        String currentReceipt = cashRegister.printReceipt();
        Assert.assertEquals(expectedReceipt,currentReceipt);
    }

    @Test
    public void multipleSameItemsAndOneDifferentTest() {
        String input = "large coffee with foamed milk, small coffee with special roast, large coffee with foamed milk, " +
                "large coffee with foamed milk, large coffee with foamed milk";
        String expectedReceipt = ResourceReaderUtil.readReceipt("receipts/integration-multiple-same-items-and-one-different-receipt");
        CashRegister cashRegister = new CashRegister();
        InputParser.parseInputItems(input)
                .forEach(cashRegister::addMenuItem);
        String currentReceipt = cashRegister.printReceipt();
        Assert.assertEquals(expectedReceipt,currentReceipt);
    }

    @Test
    public void skipUnknownTest() {
        String input = "large coffee with foamed milk, small coffee with special roast, large coffee with cream";
        String expectedReceipt = ResourceReaderUtil.readReceipt("receipts/integration-skip-unknown-receipt");
        CashRegister cashRegister = new CashRegister();
        InputParser.parseInputItems(input)
                .forEach(cashRegister::addMenuItem);
        String currentReceipt = cashRegister.printReceipt();
        Assert.assertEquals(expectedReceipt,currentReceipt);
    }

    @Test
    public void snackAndBeverageDiscountTest() {
        String input = "large coffee with foamed milk, bacon roll";
        String expectedReceipt = ResourceReaderUtil.readReceipt("receipts/integration-snack-and-beverage-discount-receipt");
        CashRegister cashRegister = new CashRegister();
        InputParser.parseInputItems(input)
                .forEach(cashRegister::addMenuItem);
        String currentReceipt = cashRegister.printReceipt();
        Assert.assertEquals(expectedReceipt,currentReceipt);
    }

}
