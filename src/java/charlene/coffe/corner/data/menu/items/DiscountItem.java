package charlene.coffe.corner.data.menu.items;

import charlene.coffe.corner.utils.Constants;

public class DiscountItem extends MenuItem {

    public DiscountItem(MenuItem item) {
        super(item.getTitle(), item.getDiscountPrice().negate());
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
        return "discount " + getTitle().toLowerCase();
    }

    @Override
    public String formatForReceipt() {
        return String.format(Constants.MENU_ITEM_RECEIPT_FORMAT, "Discount " + getTitle(), getPrice(), Constants.CURRENCY);
    }
}
