package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int dasePrice;
    private final int discountPrice;


    public DiscountedProduct(String name, int dasePrice, int discountPrice) {
        super(name);
        this.dasePrice = dasePrice;
        this.discountPrice = discountPrice;
    }

    @Override
    public int getPrice() {
        return dasePrice - (dasePrice * discountPrice / 100);
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + "(" + discountPrice + ")";
    }
}