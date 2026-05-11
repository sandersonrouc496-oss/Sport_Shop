
package ui;

import model.*;
import service.Shop;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private Shop shop = new Shop();

    public Menu() {

        shop.addProduct(new Product(1, "Футбольный мяч", 2500, Category.FOOTBALL));
        shop.addProduct(new Product(2, "Кроссовки Nike", 12000, Category.SHOES));
        shop.addProduct(new Product(3, "Гантели", 5000, Category.FITNESS));
    }

    public void start() {

        while (true) {

            printMenu();

            try {

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1 -> shop.showProducts();
                    case 2 -> addProduct();
                    case 3 -> removeProduct();
                    case 4 -> searchProduct();
                    case 5 -> createOrder();
                    case 6 -> shop.showOrders();

                    case 0 -> {
                        System.out.println("Выход...");
                        return;
                    }

                    default -> System.out.println("Нет такого пункта!");
                }

            } catch (NumberFormatException e) {

                System.out.println("Ошибка! Нужно вводить число!");

            } finally {

                System.out.println();
            }
        }
    }

    private void printMenu() {

        System.out.println("===== СПОРТ МАГАЗИН =====");
        System.out.println("1. Показать товары");
        System.out.println("2. Добавить товар");
        System.out.println("3. Удалить товар");
        System.out.println("4. Поиск товара");
        System.out.println("5. Оформить заказ");
        System.out.println("6. Показать заказы");
        System.out.println("0. Выход");
        System.out.print("Выбор: ");
    }

    private void addProduct() {

        try {

            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());


            System.out.print("Название: ");
            String name = scanner.nextLine();

            System.out.print("Цена: ");
            double price = Double.parseDouble(scanner.nextLine());

            if (price <= 0) {
                throw new IllegalArgumentException("Цена должна быть больше 0!");
            }

            System.out.println("Категории:");
            System.out.println("1 - FOOTBALL");
            System.out.println("2 - FITNESS");
            System.out.println("3 - SHOES");
            System.out.println("4 - BASKETBALL");
            System.out.print("Выбор категории: ");

            int categoryChoice = Integer.parseInt(scanner.nextLine());

            Category category;

            switch (categoryChoice) {
                case 1 -> category = Category.FOOTBALL;
                case 2 -> category = Category.FITNESS;
                case 3 -> category = Category.SHOES;
                case 4 -> category = Category.BASKETBALL;
                default -> {
                    System.out.println("Неверная категория!");
                    return;
                }
            }

            Product product = new Product(id, name, price, category);

            shop.addProduct(product);

        } catch (NumberFormatException e) {

            System.out.println("Ошибка ввода!");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }
//Инкапсуляция
    private void removeProduct() {

        try {

            System.out.print("Введите ID товара: ");
            int id = Integer.parseInt(scanner.nextLine());

            shop.removeProduct(id);

        } catch (NumberFormatException e) {

            System.out.println("Ошибка ввода!");
        }
    }

    private void searchProduct() {

        System.out.print("Введите название товара: ");
        String name = scanner.nextLine();

        Item found = shop.findByName(name);

        if (found != null) {
            System.out.println("Товар найден:");
            System.out.println(found.getInfo());
        } else {
            System.out.println("Товар не найден!");
        }
    }

    private void createOrder() {

        System.out.print("Имя клиента: ");
        String customerName = scanner.nextLine();

        Order order = new Order(customerName);

        while (true) {

            shop.showProducts();

            System.out.print("Введите ID товара (0 чтобы закончить): ");

            try {

                int id = Integer.parseInt(scanner.nextLine());

                if (id == 0) {
                    break;
                }

                Item item = shop.findById(id);

                if (item != null) {
                    order.addProduct((Product) item);
                    System.out.println("Товар добавлен в заказ!");
                } else {
                    System.out.println("Товар не найден!");
                }

            } catch (NumberFormatException e) {

                System.out.println("Ошибка ввода!");
            }
        }

        shop.addOrder(order);

        System.out.println("Заказ оформлен!");
    }
    protected void sellUndo() {


    }

}
