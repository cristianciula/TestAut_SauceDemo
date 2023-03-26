package testdata;

import utils.Reader;

public class Product {

    private String name;
    private String description;
    private String price;

    public Product(String fileName) {
        this.name = Reader.json(fileName).get("name").toString();
        this.description = Reader.json(fileName).get("description").toString();
        this.price = Reader.json(fileName).get("price").toString();
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
