package org.skypro.skyshop.product;

public class Product {

    // Поля
    private String name;
    private int price;

    // Конструктор
    public Product (String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Геттеры
    public String getName() {return name;}
    public int getPrice() {return price;}

    @Deprecated
    public String toString() {
        return "(Продукт = " + getName() + ") (" +
                "цена = " +getPrice() + ")";
    }
}
