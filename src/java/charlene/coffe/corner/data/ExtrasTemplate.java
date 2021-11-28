package charlene.coffe.corner.data;

import charlene.coffe.corner.data.menu.items.Extra;

import java.math.BigDecimal;
import java.util.function.Supplier;

public enum ExtrasTemplate {

    //    EXTRAS
    EXTRA_MILK(() -> new Extra("Extra milk", BigDecimal.valueOf(0.30))),
    FOAMED_MILK(() -> new Extra("Foamed milk", BigDecimal.valueOf(0.50))),
    SPECIAL_ROAST(() -> new Extra("Special roast", BigDecimal.valueOf(0.90)));

    private Supplier<Extra> itemSupplier;

    ExtrasTemplate(Supplier<Extra> itemSupplier) {
        this.itemSupplier = itemSupplier;
    }

    public Extra create() {
        return this.itemSupplier.get();
    }

}
