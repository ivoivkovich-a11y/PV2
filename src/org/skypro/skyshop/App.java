package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.Set;


public class App {
    private static Object test3;

    public static void main(String[] args) {
        org.skypro.skyshop.basket.ProductBasket basket = new org.skypro.skyshop.basket.ProductBasket();
        //Товары

        SimpleProduct phone = new SimpleProduct("phone", 100);
        SimpleProduct screen = new SimpleProduct("screen", 75);
        SimpleProduct speaker = new SimpleProduct("speaker", 50);
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

        // Вывод результатов поиска из отсортированной по имени
        System.out.println(" Результаты поиска по запросу 'тел'");
        Set<Searchable> searchResults = searchEngine.search("тел");

        if (searchResults.isEmpty()) {
            System.out.println("Результаты не найдены");
        } else {
            for (Searchable item : searchResults) {
                System.out.println(item.getStringRepresentation());
                System.out.println();
            }
        }

        // Проверка исключения для нулевой цены
        System.out.println("Проверка исключения цена ноль");
        try {
            SimpleProduct invalidProduct = new SimpleProduct("invalid", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Проверка Поиск с разной длиной
        System.out.println("Тест Поиск с разной длиной");
        SearchEngine test1 = new SearchEngine(10);
        test1.add(new SimpleProduct("phone", 100));
        test1.add(new SimpleProduct("screen", 75));
        test1.add(new SimpleProduct("speaker", 50));
        test1.add(new SimpleProduct("microphone", 25));

        Set<Searchable> results1 = test1.search("s");
        System.out.println("Результаты поиска 's' сортировка от большего к меньшему");
        for (Searchable item : results1) {
            System.out.println(item.getStringRepresentation());
        }

        // Проверка Поиск с одинаковой длиной
        System.out.println("Тест Поиск с одинаковой длиной");
        SearchEngine test2 = new SearchEngine(10);
        test2.add(new SimpleProduct("phone", 100));
        test2.add(new SimpleProduct("screen", 75));
        test2.add(new SimpleProduct("speaker", 50));
        test2.add(new SimpleProduct("microphone", 25));
        test2.add(new SimpleProduct("train", 45));

        Set<Searchable> results2 = test2.search("n");
        System.out.println("Результаты поиска 'n' сортировка от меньшего к большему");
        for (Searchable item : results2) {
            System.out.println(item.getStringRepresentation());
        }

        // Проверка Комбинированная сортировка (разные длины + натуральный порядок)
        System.out.println("Тест Комбинированная сортировка");
        SearchEngine test3 = new SearchEngine(10);
        test3.add(new SimpleProduct("phone", 100));
        test3.add(new SimpleProduct("screen", 75));
        test3.add(new SimpleProduct("speaker", 50));
        test3.add(new SimpleProduct("microphone", 25));

        Set<Searchable> results3 = test3.search("s");
        System.out.println("Результаты поиска 's'");
        for (Searchable item : results3) {
            System.out.println(item.getStringRepresentation());
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
//1

