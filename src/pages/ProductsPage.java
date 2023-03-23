package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By pageTitle = By.xpath("//span[@class=\"title\"]");
    private By productTitles = By.xpath("//div[@class=\"inventory_item_name\"]");

    //ACTIONS
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public List<String> getProductNames() {
        List<WebElement> productTitleLabels = driver.findElements(productTitles);
        List<String> productNames = new ArrayList<String>();

        for (WebElement productTitleLabel:productTitleLabels) {
            productNames.add(productTitleLabel.getText());
        }
        return productNames;
    }
}
