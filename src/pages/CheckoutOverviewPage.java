package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.HexConverter;

public class CheckoutOverviewPage {
    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    private By pageTitle = By.xpath("//span[@class=\"title\"]");
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");

    //ACTIONS
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }
    public boolean cancelButtonIsEnabled() {
        return driver.findElement(cancelButton).isEnabled();
    }
    public boolean finishButtonIsEnabled() {
        return driver.findElement(finishButton).isEnabled();
    }
    public String getFinishButtonColor() {
        String rgba = driver.findElement(finishButton).getCssValue("background-color");
        return HexConverter.rgbaToHex(rgba);
    }
    public String getFinishButtonText() {
        return driver.findElement(finishButton).getText();
    }
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }
}
