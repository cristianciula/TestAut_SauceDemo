package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HexConverter;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By pageTitle = By.xpath("//span[@class=\"title\"]");
    private By productNameLabels = By.xpath("//div[@class=\"inventory_item_name\"]");
    private By checkoutButton = By.id("checkout");
    private By productQuantityLabel(String productName) {
        return By.xpath("//div[@class=\"inventory_item_name\"][text()=\""+productName+"\"]/ancestor::div[@class=\"cart_item\"]/div[@class=\"cart_quantity\"]");
    }

    //ACTIONS
    public List<String> getAllProductsInCart() {
        List<WebElement> productsNamesLabels = driver.findElements(productNameLabels);
        List<String> productsNames = new ArrayList<>();

        for (WebElement productNameLabel : productsNamesLabels) {
            productsNames.add(productNameLabel.getText());
        }
        return productsNames;
    }
    public boolean checkoutButtonIsEnabled() {
        return driver.findElement(checkoutButton).isEnabled();
    }
    public String getCheckoutButtonColor() {
        String rgba = driver.findElement(checkoutButton).getCssValue("background-color");
        return HexConverter.rgbaToHex(rgba);
    }
    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }
    public String getProductQuantity(String productName) {
        return driver.findElement(productQuantityLabel(productName)).getText();
    }
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
}
