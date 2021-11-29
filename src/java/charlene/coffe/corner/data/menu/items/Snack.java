package charlene.coffe.corner.data.menu.items;


import java.math.BigDecimal;

public class Snack extends MenuItem {

    public Snack(String title, BigDecimal price) {
        super(title, price);
    }

    @Override
    public boolean compareItem(MenuItem menuItem) {
        if(menuItem != null && this.getClass() == menuItem.getClass()){
            return super.compareItem(menuItem);
        }
        return false;
    }

}
