package org.skypro.skyshop;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        org.skypro.skyshop.basket.ProductBasket basket = new org.skypro.skyshop.basket.ProductBasket();
        //Товары
        Product phone = new Product("phone", 1000);
        Product screen = new Product("screen", 450);
        Product speaker = new Product("speaker", 75);
        Product microphone = new Product("microphone", 150);
        Product train = new Product("train", 150);

        System.out.println("Добавлени товара в корзину");
        basket.addProduct(phone);
        System.out.println(phone);
        basket.printSeparator();

        System.out.println("Добавлени товара в корзину, в которой нет свободного места.");
        basket.addProduct(screen);
        basket.addProduct(speaker);
        basket.addProduct(microphone);
        basket.addProduct(screen);
        basket.addProduct(train);
        basket.printSeparator();

        System.out.println("Печать содержимого корзины с несколькими товарами и получение стоимости корзины с несколькими товарами");
        basket.printSum1();
        basket.printSeparator();

        System.out.println("Получение стоимости корзины с несколькими товарами");
        basket.printSum();
        basket.printSeparator();

        System.out.println("Поиск товара, который есть в корзине");
        System.out.println( basket.search("microphone"));
        basket.printSeparator();

        System.out.println("Поиск товара, которого нет в корзине");
        System.out.println(basket.search("Килька"));
        basket.printSeparator();

        System.out.println("Очистка корзины, печать содержимого пустой корзины, получение стоимости пустой корзины.");
        basket.cleaning();
        basket.printSum1();
        basket.printSeparator();

        System.out.println("Поиск товара по имени в пустой корзине");
        System.out.println(basket.search("screen"));
        basket.printSum1();
    }
}
//11
