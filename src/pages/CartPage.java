package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By productNameLabels = By.xpath("//div[@class=\"inventory_item_name\"]");
    private By productDescription(String productName) {
        return By.xpath("//div[@class=\"inventory_item_desc\"][contains(.,\""+productName+"\")]");
    }
    private By continueShoppingButton = By.id("continue-shopping");
    private By productsList = By.xpath("//div[@class=\"cart_list\"]");
    private By productPrice(String productName) {
        return By.xpath("//div[@class=\"inventory_item_name\"][contains(.,\""+productName+"\")]/following::div[@class=\"inventory_item_price\"]");
    }

    //ACTIONS
    public List<String> getAllProductsInCart() {
        List<WebElement> productsNamesLabels = driver.findElements(productNameLabels);
        List<String> productsNames = new ArrayList<String>();

        for (WebElement productNameLabel : productsNamesLabels) {
            productsNames.add(productNameLabel.getText());
        }
        return productsNames;
    }
    public String getProductPrice(String productName) {
        return driver.findElement(productPrice(productName)).getText();
    }
    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }
}
