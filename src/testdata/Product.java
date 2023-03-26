package testdata;

import utils.Reader;

public class Product {

    private String title;
    private String description;
    private String price;

    public Product(String fileName) {
        this.title = Reader.json(fileName).get("name").toString();
        this.description = Reader.json(fileName).get("description").toString();
        this.price = Reader.json(fileName).get("price").toString();
    }

    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPrice() {
        return price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}
