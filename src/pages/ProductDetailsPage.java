package pages;

import org.openqa.selenium.WebDriver;
import testdata.Product;

public class ProductDetailsPage {
    WebDriver driver;

    public static Product product = new Product("product");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS


    //ACTIONS
}
