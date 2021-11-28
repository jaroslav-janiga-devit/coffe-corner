package charlene.coffe.corner.data.menu.types;

import java.math.BigDecimal;

public enum BeverageSize {
    SMALL("small",new BigDecimal("2.50")),
    MEDIUM("medium",new BigDecimal("3")),
    LARGE("large",new BigDecimal("3.50"));

    private String name;
    private BigDecimal price;

    BeverageSize(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
