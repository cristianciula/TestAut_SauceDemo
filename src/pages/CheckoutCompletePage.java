package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.HexConverter;

public class CheckoutCompletePage {
    WebDriver driver;

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By pageTitle = By.xpath("//span[@class=\"title\"]");
    private By checkmarkImage = By.xpath("//img[@class=\"pony_express\"]");
    private By header = By.xpath("//h2[@class=\"complete-header\"]");
    private By message = By.xpath("//div[@class=\"complete-text\"]");
    private By backHomeButton = By.id("back-to-products");

    //ACTIONS
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
    public String getCheckmarkImage() {
        return driver.findElement(checkmarkImage).getAttribute("src");
    }
    public String getHeader() {
        return driver.findElement(header).getText();
    }
    public String getMessage() {
        return driver.findElement(message).getText();
    }
    public String getBackToProductsButtonText() {
        return driver.findElement(backHomeButton).getText();
    }
    public String getBackToProductsButtonColor() {
        String rgba = driver.findElement(backHomeButton).getCssValue("background-color");
        return HexConverter.rgbaToHex(rgba);
    }
    public boolean backToProductsButtonIsEnabled() {
        return driver.findElement(backHomeButton).isEnabled();
    }
    public void clickBackToProductsButton() {
        driver.findElement(backHomeButton).click();
    }
}
