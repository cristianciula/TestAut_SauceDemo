package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.HexConverter;

public class CheckoutInfoPage {
    WebDriver driver;

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By pageTitle = By.xpath("//span[@class=\"title\"]");
    private By continueButton = By.id("continue");


    //ACTIONS
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
    public boolean continueButtonIsEnabled() {
        return driver.findElement(continueButton).isEnabled();
    }
    public String getContinueButtonColor() {
        String rgba = driver.findElement(continueButton).getCssValue("background-color");
        return HexConverter.rgbaToHex(rgba);
    }
}
