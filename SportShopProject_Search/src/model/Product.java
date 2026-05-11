
package model;

public class Product extends Item {

    public Product(int id, String name, double price, Category category) {
        super(id, name, price, category);
    }
//тут

    @Override
    public String getInfo() {
        return "ID: " + getId()
                + " | Название: " + getName()
                + " | Цена: " + getPrice()
                + " | Категория: " + getCategory();
    }
}
