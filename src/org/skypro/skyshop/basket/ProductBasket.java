package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;


public class ProductBasket {
    private final Map<String, List<Product>> products = new LinkedHashMap<>();

    // Добавление продукта
    public void addProduct(Product product) {
        String productName = product.getName();
        products.computeIfAbsent(productName, k -> new ArrayList<>()).add(product);
    }

    // Печать общей стоимости корзины
    public void printSum(){
        int sum = products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
        System.out.println(sum);
    }

    // Печать каждой позиции и итого
    public void printSum1(){
        if (!products.isEmpty()) {
            products.values().stream()
                    .flatMap(Collection::stream)
                    .forEach(System.out::println);
            int sum = products.values().stream()
                    .flatMap(Collection::stream)
                    .mapToInt(Product::getPrice)
                    .sum();
            System.out.println("Итого: " + sum);
        } else System.out.println("В корзине пусто");

    }

    // Печать разделителя
    public void printSeparator() {
        System.out.println("===================");
    }

    // Проверка продукта в корзине по имени
    public boolean search(String nameSearch) {
        return products.containsKey(nameSearch);
    }

    //  Очистка корзины
    public void cleaning() {
        products.clear();
    }

    // Удаление продуктов по имени
    public List<Product> removeProduct(String productName) {
        List<Product> removed = products.remove(productName);
        return removed != null ? removed : new ArrayList<>();
    }

    public void printNumberOfSpecialItems() {
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        int total = products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();

        long specialCount = getSpecialCount();

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }

    // Подсчёт количества специальных товаров
    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }
}



//11
