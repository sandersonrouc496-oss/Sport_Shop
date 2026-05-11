
package model;

public abstract class Item implements Printable {
//поле
    private int id;
    private String name;
    private double price;
    private Category category;
    //(модификаторы входит private public )
    public Item(int id, String name, double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public abstract String getInfo();
}
//полиморфизм здесь и в product это super