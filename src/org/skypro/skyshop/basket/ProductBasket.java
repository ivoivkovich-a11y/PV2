package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;
public class ProductBasket {
    private final Product[] products = new Product[5];

    // Добавление продукта
    public void addProduct(Product product) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] == null) {
                products[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
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
        int sum = 0;
        for (Product product: products) {
            if (product == null) break;
            sum += product.getPrice();
            System.out.println(product);
        }
        System.out.println("Итого: " + sum);
    }
}
