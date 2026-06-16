package org.skypro.skyshop;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
public class App {
    public static void main(String[] args) {
        org.skypro.skyshop.basket.ProductBasket basket = new org.skypro.skyshop.basket.ProductBasket();
        Product apple = new Product("apple", 100);
        Product banana = new Product("banana", 150);
        basket.addProduct(apple);
        basket.addProduct(banana);
        System.out.println(apple);
        basket.printSum();
        basket.printSum1();


    }
}

