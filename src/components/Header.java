package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By shoppingCart = By.id("shopping_cart_container");

    //ACTIONS
    public boolean shoppingCartIsDisplayed() {
        return driver.findElement(shoppingCart).isDisplayed();
    }
}
