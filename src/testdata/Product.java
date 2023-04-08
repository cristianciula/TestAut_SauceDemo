package testdata;

import utils.Reader;

public class Product {

    private String name;
    private String description;
    private double price;

    public Product(String fileName) {
        this.name = Reader.json(fileName).get("name").toString();
        this.description = Reader.json(fileName).get("description").toString();
        this.price = (double) Reader.json(fileName).get("price");
    }

    //GETTERS
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
