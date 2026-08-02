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
}



//1
