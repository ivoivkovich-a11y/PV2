package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;
import java.util.Map;


public class App {
    public static void main(String[] args) {
        org.skypro.skyshop.basket.ProductBasket basket = new org.skypro.skyshop.basket.ProductBasket();
        //Товары

        SimpleProduct phone = new SimpleProduct("phone", 100);
        SimpleProduct screen = new SimpleProduct("screen", 75);
        SimpleProduct speaker = new SimpleProduct("speaker", 0);
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

        Article phoneArticle = new Article("телефон", "Быстрый и с большим объёмом ОЗУ");
        Article shoppingGuide = new Article("Как определиться с товаром", "Определитесь с объёмом ОЗУ");
        Article theRightChoice = new Article("Правильный выбор", "Правильно подобранное количество ОЗУ поможет быстро выполнять поставленные задачи");

        searchEngine.add(phoneArticle);
        searchEngine.add(shoppingGuide);
        searchEngine.add(theRightChoice);

        // Вывод результатов поиска из отсортированной по имени Map
        System.out.println(" Результаты поиска по запросу 'тел'");
        Map<String, Searchable> searchResults = searchEngine.search("тел");

        if (searchResults.isEmpty()) {
            System.out.println("Результаты не найдены");
        } else {
            for (Map.Entry<String, Searchable> entry : searchResults.entrySet()) {
                System.out.println("Название: " + entry.getKey());
                System.out.println("Содержание: " + entry.getValue().getStringRepresentation());
                System.out.println();
            }
        }
/*
        //Проверки
        try {
            SimpleProduct phone = new SimpleProduct("    ", 100);
            SearchEngine searchEngine = new SearchEngine(10);
            searchEngine.add(phone);
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование только из пробелов");
        }

        try {
            SimpleProduct phone = new SimpleProduct(null, 100);
            SearchEngine searchEngine = new SearchEngine(10);
            searchEngine.add(phone);
        } catch (IllegalArgumentException e) {
            System.out.println("Наименование null");
        }
        try {
            SimpleProduct screen = new SimpleProduct("screen", -100);
            SearchEngine searchEngine = new SearchEngine(10);
            searchEngine.add(screen);
        } catch (IllegalArgumentException e) {
            System.out.println("Цена не может быть меньше или равна нулю");
        }
        try {
            DiscountedProduct phoneNEW = new DiscountedProduct("phoneNEW", 100, -20);
            SearchEngine searchEngine = new SearchEngine(10);
            searchEngine.add(phoneNEW);
        } catch (IllegalArgumentException e) {
            System.out.println("Скидку должна быть от нуля до ста");
        }

        SearchEngine engine = new SearchEngine(5);

        engine.add(new SimpleProduct("телефон ультратонкий", 50));
        engine.add(new SimpleProduct("телефонный брелок", 100));
        engine.add(new SimpleProduct("телефон", 60));


        try {
            Searchable result = engine.findMostRelevant("телефон");
            System.out.println("Найден лучший результат: " + result.getStringRepresentation());
        } catch (SearchEngine.BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // 2. Сценарий: объект НЕ найден
        try {
            Searchable result = engine.findMostRelevant("Экран");
            System.out.println("Найден лучший результат: " + result.getStringRepresentation());
        } catch (SearchEngine.BestResultNotFound e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
*/
    }
}
//11

