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
       // SimpleProduct phone = new SimpleProduct("phone", 100);
        SimpleProduct phone = new SimpleProduct("    ", 100);
       // SimpleProduct screen = new SimpleProduct("screen", 75);
        SimpleProduct screen = new SimpleProduct(null, 75);
        //SimpleProduct speaker = new SimpleProduct("speaker", 0);
        SimpleProduct speaker = new SimpleProduct("speaker", -0);
        SimpleProduct microphone = new SimpleProduct("microphone", 25);
        SimpleProduct train = new SimpleProduct("train", 45);
       // DiscountedProduct phoneNEW = new DiscountedProduct("phone", 100, 20);
       // DiscountedProduct phoneNEW = new DiscountedProduct("phone", 100, -20);
        DiscountedProduct phoneNEW = new DiscountedProduct("phone", 100, 200);

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

    }

}


//11
