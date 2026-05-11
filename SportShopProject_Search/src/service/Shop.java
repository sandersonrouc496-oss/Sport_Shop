
package service;

import model.Item;
import model.Order;

import java.util.ArrayList;

public class Shop {

    private ArrayList<Item> products;
    private ArrayList<Order> orders;

    public Shop() {
        products = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addProduct(Item item) {
        products.add(item);
        System.out.println("Товар добавлен!");
    }

    public void showProducts() {

        if (products.isEmpty()) {
            System.out.println("Товаров нет!");
            return;
        }

        for (Item item : products) {
            System.out.println(item.getInfo());
        }
    }

    public Item findById(int id) {

        for (Item item : products) {

            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }

    public Item findByName(String name) {

        for (Item item : products) {

            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;
    }

    public void removeProduct(int id) {

        Item found = findById(id);

        if (found != null) {
            products.remove(found);
            System.out.println("Товар удалён!");
        } else {
            System.out.println("Товар не найден!");
        }
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void showOrders() {

        if (orders.isEmpty()) {
            System.out.println("Заказов нет!");
            return;
        }

        for (Order order : orders) {
            order.printOrder();
        }
    }
}
