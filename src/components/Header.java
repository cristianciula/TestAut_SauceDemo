package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By shoppingCartButton = By.id("shopping_cart_container");
    private By shoppingCartCounter = By.xpath("//a[@class=\"shopping_cart_link\"]");
    private By menuButton = By.id("react-burger-menu-btn");
    private By menuSidebar = By.xpath("//div[@class=\"bm-menu\"]");
    private By logoutButton = By.id("logout_sidebar_link");

    //ACTIONS
    public boolean shoppingCartIsDisplayed() {
        return driver.findElement(shoppingCartButton).isDisplayed();
    }
    public void clickMenu() {
        driver.findElement(menuButton).click();
    }
    public boolean menuSidebarIsDisplayed() {
        return driver.findElement(menuSidebar).isDisplayed();
    }
    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
    public String getCartCounterValue() {
        return driver.findElement(shoppingCartCounter).getText();
    }
    public boolean cartCounterIsDisplayed() {
        return !driver.findElement(shoppingCartCounter).getText().isEmpty();
    }
}
