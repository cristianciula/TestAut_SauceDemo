package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    WebDriver driver;
    public static Product product = new Product("product");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By pageTitle = By.xpath("//span[@class=\"title\"]");
    private By productTitleLabel = By.xpath("//div[@class=\"inventory_item_name\"]");
    private By addToCartButton(String productName) {
        return By.xpath("//div[@class=\"inventory_item_name\"][contains(.,\""+productName+"\")]/following::button[1]");
    }
    private By removeButton(String productName) {
        return By.xpath("//div[@class=\"inventory_item_name\"][contains(.,\""+productName+"\")]/following::button[contains(.,\"Remove\")][1]");
    }
    private By productName(String productName) {
        return By.xpath("//div[@class=\"inventory_item_name\"][contains(.,\""+productName+"\")]");
    }
    private By productImage(String productName) {
        return By.xpath("//img[@class=\"inventory_item_img\"][@alt=\""+productName+"\"]");
    }

    //ACTIONS
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
    public List<String> getAllProductsNames() {
        List<WebElement> productsNamesLabels = driver.findElements(productTitleLabel);
        List<String> productsNames = new ArrayList<String>();

        for (WebElement productNameLabel : productsNamesLabels) {
            productsNames.add(productNameLabel.getText());
        }
        return productsNames;
    }
    public void clickAddToCartButton(String productName) {
        driver.findElement(addToCartButton(productName)).click();
    }
    public String getAddToCartButtonText(String productName) {
        return driver.findElement(addToCartButton(productName)).getText();
    }
    public void clickRemoveButton(String productName) {
        driver.findElement(removeButton(productName)).click();
    }
    public String getRemoveButtonText(String productName) {
        return driver.findElement(removeButton(productName)).getText();
    }
    public void clickProductName(String productName) {
        driver.findElement(productName(product.getName())).click();
    }
    public boolean productImageIsDisplayed(String productName) {
        return driver.findElement(productImage(productName)).isDisplayed();
    }
    public String getProductImage(String productName) {
        return driver.findElement(productImage(productName)).getAttribute("src");
    }
}
