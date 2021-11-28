package charlene.coffe.corner.data.menu.items;

import charlene.coffe.corner.data.menu.types.BeverageSize;
import charlene.coffe.corner.utils.Constants;

import java.math.BigDecimal;

public class Beverage extends MenuItem {

    private Extra extra;
    private BeverageSize beverageSize;

    public Beverage(String title, Extra extra, BeverageSize beverageSize) {
        super(title, beverageSize.getPrice());
        this.extra = extra;
        this.beverageSize = beverageSize;
    }

    public Beverage(String title, BeverageSize beverageSize) {
        super(title, beverageSize.getPrice());
        this.beverageSize = beverageSize;
    }

    public Beverage(String title, BigDecimal price) {
        super(title, price);
    }

    @Override
    public BigDecimal getPrice() {
        return extra == null
                ? super.getPrice()
                : super.getPrice().add(extra.getPrice());
    }

    @Override
    public boolean compareItem(MenuItem menuItem) {
        if (menuItem != null && this.getClass() == menuItem.getClass()) {
            Beverage itemToCompare = (Beverage) menuItem;
            return beverageSize == itemToCompare.beverageSize
                    && super.compareItem(itemToCompare)
                    && ((extra == null && itemToCompare.extra == null)
                    || (extra != null && extra.compareItem(itemToCompare.extra)));
        }
        return false;
    }

    @Override
    public String toString() {
        return (beverageSize == null ? "" : beverageSize.getName().toLowerCase() + " ") +
                getTitle().toLowerCase() +
                (extra == null ? "" : extra);
    }

    @Override
    public String formatForReceipt() {
        String name = (beverageSize == null ? "" : beverageSize.getName() + " ") + getTitle();
        return String.format(Constants.MENU_ITEM_RECEIPT_FORMAT, name, super.getPrice(), Constants.CURRENCY) +
                (extra == null ? "" : "\n" + extra.formatForReceipt());
    }


}
