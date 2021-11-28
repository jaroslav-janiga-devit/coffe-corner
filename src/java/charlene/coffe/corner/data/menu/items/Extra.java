package charlene.coffe.corner.data.menu.items;

import java.math.BigDecimal;

public class Extra extends MenuItem {

    public Extra(String title, BigDecimal price) {
        super(title, price);
    }

    @Override
    public boolean compareItem(MenuItem menuItem) {
        if (menuItem != null && this.getClass() == menuItem.getClass()) {
            return super.compareItem(menuItem);
        }
        return false;
    }

    @Override
    public String toString() {
        return " with " + getTitle().toLowerCase();
    }

    @Override
    public String formatForReceipt() {
        return String.format("\t%s", super.formatForReceipt());
    }
}
