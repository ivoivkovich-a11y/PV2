package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {

    // Поля
    String name;
    //private final int price;

    // Конструктор
    public Product(String name) {
        this.name = name;
        //this.price = price;
    }
    // Геттеры
    //public String getName() {return name;}

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Deprecated
    public String toString() {
        return "Продукт = " + getName() + ") (" +
                "цена = " + getPrice() + ")";
    }
    @Override
    public String getSearchTerm() {return getName();}

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getStringRepresentation() { return toString();}


    @Override
    public String getName() {
        return name;
    }

}


//1