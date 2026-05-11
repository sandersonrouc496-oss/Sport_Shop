
package model;

import java.util.ArrayList;

public class Order {
//метод
    private String customerName;
    private ArrayList<Product> products;

    public Order(String customerName) {
        this.customerName = customerName;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {

        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public void printOrder() {

        System.out.println("Клиент: " + customerName);

        for (Product product : products) {
            System.out.println(product.getInfo());
        }

        System.out.println("Общая сумма: " + getTotalPrice());
    }
}
