package charlene.coffe.corner.management;

import charlene.coffe.corner.data.menu.items.MenuItem;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Basket {

    private List<BasketItem> items;

    public Basket() {
        this.items = new LinkedList<>();
    }

    public void add(MenuItem menuItem) {
        if(menuItem == null) return;
        items.stream()
                .filter(basketItem -> basketItem.contains(menuItem))
                .findFirst()
                .ifPresentOrElse(BasketItem::increaseCount, () -> items.add(this.create(menuItem)));
    }

    public void remove(MenuItem menuItem) {
        if(menuItem == null) return;
        Optional<BasketItem> item = items.stream()
                .filter(basketItem -> basketItem.contains(menuItem))
                .findFirst();
        if (item.isPresent()) {
            BasketItem basketItem = item.get();
            if (basketItem.getCount() == 1) {
                items.remove(basketItem);
            } else {
                basketItem.decreaseCount();
            }
        }
    }

    public BigDecimal totalPrice() {
        return items.stream()
                .map(BasketItem::price)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BasketItem create(MenuItem menuItem) {
        return new BasketItem(menuItem, 1);
    }

    public List<BasketItem> getItems() {
        return items;
    }


}
