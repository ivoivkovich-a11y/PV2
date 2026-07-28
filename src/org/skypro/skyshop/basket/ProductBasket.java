package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class ProductBasket {
    private final List<Product> products = new LinkedList<>();

    // Добавление продукта
    public void addProduct(Product product) {
        products.add(product);
    }

    // Печать общей стоимости корзины
    public void printSum(){
        int sum = 0;
        for (Product product: products) {
            if (product == null) break;
            sum += product.getPrice();
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
        for (Product product : products) {
            sum += product.getPrice();
            System.out.println(product);
        }
        System.out.println("Итого: " + sum);
    }

    // Печать разделителя
    public void printSeparator() {
        System.out.println("===================");
    }

    // Проверка продукта в корзине по имени
    public boolean search(String nameSearch) {
        for (Product product : products) {
            if (product != null && product.getName().equals(nameSearch)) {
                return true;
            }
        }
        return false;
    }

    //  Очистка корзины
    public void cleaning() {
        products.clear();
    }
/*
// Kоличество специальных товаров
    public void printNumberOfSpecialItems() {
        int specialCount = 0;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            System.out.println(product.toString());
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Специальных товаров: " + specialCount);
    }
*/
    public void printNumberOfSpecialItems() {
        int total = 0;
        int specialCount = 0;

        for (Product p : products) {
            System.out.println(p);
            total += p.getPrice();
            if (p.isSpecial()) {
                specialCount++;
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



//1
