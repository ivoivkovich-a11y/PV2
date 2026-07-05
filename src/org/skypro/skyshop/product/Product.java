package org.skypro.skyshop.product;

public abstract class Product {

    // Поля
    String name;
    //private final int price;

    // Конструктор
    public Product(String name) {
        this.name = name;
        //   this.price = price;
    }
    // Геттеры
    public String getName() {return name;}
    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Deprecated
    public String toString() {
        return "Продукт = " + getName() + ") (" +
                "цена = " + getPrice() + ")";


    }
}


//1