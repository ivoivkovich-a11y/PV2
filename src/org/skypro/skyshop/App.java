package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;

import java.lang.reflect.Array;
import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        org.skypro.skyshop.basket.ProductBasket basket = new org.skypro.skyshop.basket.ProductBasket();
        //Товары
        SimpleProduct phone = new SimpleProduct("phone", 100);
        SimpleProduct screen = new SimpleProduct("screen", 75);
        SimpleProduct speaker = new SimpleProduct("speaker", 15);
        SimpleProduct microphone = new SimpleProduct("microphone", 25);
        SimpleProduct train = new SimpleProduct("train", 45);
        DiscountedProduct phoneNEW = new DiscountedProduct("phone", 100, 20);
        FixPriceProduct screenNEW = new FixPriceProduct("screen");

        SearchEngine searchEngine = new SearchEngine(10);

        searchEngine.add(phone);
        searchEngine.add(screen);
        searchEngine.add(speaker);
        searchEngine.add(microphone);
        searchEngine.add(train);
        searchEngine.add(phoneNEW);
        searchEngine.add(screenNEW);

        Article phoneArticle = new Article("телефон", "Быстрый и с больним объёмом ОЗУ");
        Article shoppingGuide = new Article("Как определиться с товаром", "Определитесь с объёмом ОЗУ");
        Article theRightChoice = new Article("Правильный выбор", "Правильно подобранное количество ОЗУ поможет быстро выполнять поставленные задачи");


        searchEngine.add(phoneArticle);
        searchEngine.add(shoppingGuide);
        searchEngine.add(theRightChoice);
        System.out.println(Arrays.toString(searchEngine.search("тел")));

        //getStringRepresentation(engine, "телеф");
        // printSearchResults(engine, "телеф");
/*

        //System.out.println("Добавлени товара в корзину");
        basket.addProduct(phone);
        System.out.println(phone);
        basket.printSeparator();
        basket.addProduct(phoneNEW);
        System.out.println(phoneNEW);
        basket.addProduct(screenNEW);
        basket.printSeparator();

        System.out.println(screenNEW);
        basket.printNumberOfSpecialItems();

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
        basket.printSeparator();
        basket.printNumberOfSpecialItems();
*/

    }

}


//1
