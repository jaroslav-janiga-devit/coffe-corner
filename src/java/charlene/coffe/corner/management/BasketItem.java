package charlene.coffe.corner.management;

import charlene.coffe.corner.data.menu.items.MenuItem;
import charlene.coffe.corner.utils.receipt.ReceiptItemFormatter;

import java.math.BigDecimal;

public class BasketItem implements ReceiptItemFormatter {

    private MenuItem menuItem;
    private int count;

    public BasketItem(MenuItem menuItem, int count) {
        this.menuItem = menuItem;
        this.count = count;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public boolean contains(MenuItem menuItem) {
        return this.menuItem.compareItem(menuItem);
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }

    public void decreaseCount() {
        this.count--;
    }

    @Override
    public String formatForReceipt() {
        return String.format("%-3d %s\n", count, menuItem.formatForReceipt());
    }

    public BigDecimal price() {
        return this.menuItem.getPrice().multiply(BigDecimal.valueOf(this.count));
    }
}
