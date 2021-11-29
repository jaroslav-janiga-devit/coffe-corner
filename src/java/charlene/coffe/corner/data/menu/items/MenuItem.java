package charlene.coffe.corner.data.menu.items;

import charlene.coffe.corner.utils.Constants;
import charlene.coffe.corner.utils.receipt.ReceiptItemFormatter;

import java.math.BigDecimal;

public abstract class MenuItem implements ReceiptItemFormatter {

    private String title;
    private BigDecimal price;

    public MenuItem(String title, BigDecimal price) {
        this.title = title;
        this.price = price;
    }

    public MenuItem(String title) {
        this.title = title;
        this.price = new BigDecimal(0);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean compareItem(MenuItem menuItem) {
        if (menuItem == null) return false;
        return this.title.equalsIgnoreCase(menuItem.getTitle());
    }

    @Override
    public String toString() {
        return this.title.toLowerCase();
    }

    @Override
    public String formatForReceipt() {
        return String.format(Constants.MENU_ITEM_RECEIPT_FORMAT, title, price, Constants.CURRENCY);
    }

    public BigDecimal getDiscountPrice() {
        return this.price;
    }
}
