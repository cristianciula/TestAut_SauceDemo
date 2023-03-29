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
    private By productNameLabel = By.xpath("//div[@class=\"inventory_item_name\"]");
    private By continueShoppingButton = By.id("continue-shopping");
    private By productsList = By.xpath("//div[@class=\"cart_list\"]");

    //ACTIONS
    public List<String> getAllProductsInCart() {
        List<WebElement> productsNamesLabels = driver.findElements(productNameLabel);
        List<String> productsNames = new ArrayList<String>();

        for (WebElement productNameLabel : productsNamesLabels) {
            productsNames.add(productNameLabel.getText());
        }
        return productsNames;
    }
    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }
    public boolean productIsPresentInCart(String productName) {
        return driver.findElement(productsList).getText().contains(productName);
    }
}
