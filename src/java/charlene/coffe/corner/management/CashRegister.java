package charlene.coffe.corner.management;

import charlene.coffe.corner.data.menu.items.MenuItem;
import charlene.coffe.corner.utils.receipt.ReceiptPrinter;

public class CashRegister {

    private Basket basket;

    public CashRegister() {
        this.basket = new Basket();
    }

    public void addMenuItem(MenuItem item) {
        this.basket.add(item);
    }

    public void removeMenuItem(MenuItem menuItem) {
        this.basket.remove(menuItem);
    }

    public String printReceipt(){
        basket.applySnackAndBeverageDiscount();
        return ReceiptPrinter.createReceipt(this.basket);
    }


    public void resetBasket() {
        this.basket = new Basket();
    }

}
