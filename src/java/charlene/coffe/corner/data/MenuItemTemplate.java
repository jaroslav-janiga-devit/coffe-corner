package charlene.coffe.corner.data;

import charlene.coffe.corner.data.menu.items.Beverage;
import charlene.coffe.corner.data.menu.items.Meal;
import charlene.coffe.corner.data.menu.items.MenuItem;
import charlene.coffe.corner.data.menu.types.BeverageSize;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum MenuItemTemplate {


    // BEVERAGES
    SMALL_COFFEE(() -> new Beverage("Coffee", BeverageSize.SMALL)),
    MEDIUM_COFFEE(() -> new Beverage("Coffee", BeverageSize.MEDIUM)),
    LARGE_COFFEE(() -> new Beverage("Coffee", BeverageSize.LARGE)),
    FRESH_ORANGE_JUICE(() -> new Beverage("Orange juice", BigDecimal.valueOf(3.95))),

    SMALL_COFFEE_WITH_EXTRA_MILK(() -> new Beverage("Coffee", ExtrasTemplate.EXTRA_MILK.create(), BeverageSize.SMALL)),
    SMALL_COFFEE_WITH_FOAMED_MILK(() -> new Beverage("Coffee", ExtrasTemplate.FOAMED_MILK.create(), BeverageSize.SMALL)),
    SMALL_COFFEE_SPECIAL_ROAST(() -> new Beverage("Coffee", ExtrasTemplate.SPECIAL_ROAST.create(), BeverageSize.SMALL)),

    MEDIUM_COFFEE_WITH_EXTRA_MILK(() -> new Beverage("Coffee", ExtrasTemplate.EXTRA_MILK.create(), BeverageSize.MEDIUM)),
    MEDIUM_COFFEE_WITH_FOAMED_MILK(() -> new Beverage("Coffee", ExtrasTemplate.FOAMED_MILK.create(), BeverageSize.MEDIUM)),
    MEDIUM_COFFEE_SPECIAL_ROAST(() -> new Beverage("Coffee", ExtrasTemplate.SPECIAL_ROAST.create(), BeverageSize.MEDIUM)),

    LARGE_COFFEE_WITH_EXTRA_MILK(() -> new Beverage("Coffee", ExtrasTemplate.EXTRA_MILK.create(), BeverageSize.LARGE)),
    LARGE_COFFEE_WITH_FOAMED_MILK(() -> new Beverage("Coffee", ExtrasTemplate.FOAMED_MILK.create(), BeverageSize.LARGE)),
    LARGE_COFFEE_SPECIAL_ROAST(() -> new Beverage("Coffee", ExtrasTemplate.SPECIAL_ROAST.create(), BeverageSize.LARGE)),

    //MEALS
    BEACON_ROLL(() -> new Meal("Beacon Roll", BigDecimal.valueOf(4.50)));


    private static Map<String, MenuItemTemplate> menuItems;

    static {
        menuItems = Arrays.stream(values()).collect(Collectors.toMap(i -> i.create().toString(), i -> i));
    }

    public static MenuItem menuItemOfString(String itemName) {
        MenuItemTemplate menuItemTemplate = menuItems.get(itemName);
        return menuItemTemplate == null
                ? null
                : menuItemTemplate.create();
    }


    private Supplier<MenuItem> itemSupplier;

    MenuItemTemplate(Supplier<MenuItem> itemSupplier) {
        this.itemSupplier = itemSupplier;
    }

    public MenuItem create() {
        return this.itemSupplier.get();
    }

}
