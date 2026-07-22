package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final int dasePrice;
    private final int discountPrice;


    public DiscountedProduct(String name, int dasePrice, int discountPrice) {
        if (dasePrice <= 0){
            throw new IllegalArgumentException("Базовая цена не может быть ноль или отрицательная");
        }if (discountPrice < 0 || discountPrice > 100) {
            throw new IllegalArgumentException("Скидка выходит за границы от 0 до 100");
        }
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
        return true;
    }

    @Override
    public String toString() {
        return getName() + ": " + getPrice() + "(" + discountPrice + "%)";
    }
}
//11