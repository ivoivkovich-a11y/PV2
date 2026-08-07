package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;


public class ProductBasket {
    private final Map<String, List<Product>> products = new LinkedHashMap<>();

    // Добавление продукта
    public void addProduct(Product product) {
        String productName = product.getName();
        products.computeIfAbsent(productName, k -> new ArrayList<>()).add(product);
    }

    // Печать общей стоимости корзины
    public void printSum(){
        int sum = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                sum += product.getPrice();
            }
        }
        System.out.println(sum);
    }

    // Печать каждой позиции и итого
    public void printSum1(){
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        int sum = 0;
        if (!products.isEmpty()) {
            for (List<Product> productList : products.values()) {
                for (Product product : productList) {
                    sum += product.getPrice();
                    System.out.println(product);
                }
            }
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
        int total = 0;
        int specialCount = 0;

        for (List<Product> productList : products.values()) {
            for (Product p : productList) {
                System.out.println(p.toString());
                total += p.getPrice();
                if (p.isSpecial()) {
                    specialCount++;
                }
            }
        }

        System.out.println("Итого: " + total);
        System.out.println("Специальных товаров: " + specialCount);
    }
    //Удаление продукта по имени
    public List<Product> removeByName(String name) {
        List<Product> removed = new LinkedList<>();
        Iterator<Product> iterator = products.iterator();

        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getName().equals(name)) {
                removed.add(p);
                iterator.remove();   // корректное удаление из списка
            }
        }
        return removed;
    }
    //Печать продуктов
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пустая");
            return;
        }
        for (Product p : products) {
            System.out.println(p);
        }
    }
}



//11
