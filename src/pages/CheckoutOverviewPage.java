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
    private By paymentInformationLabel = By.xpath("//div[@class=\"summary_info_label\"][1]");
    private By shippingInformationLabel = By.xpath("//div[@class=\"summary_info_label\"][2]");
    private By priceSubtotalLabel = By.xpath("//div[@class=\"summary_info_label\"][3]");
    private By paymentInformationValueLabel = By.xpath("//div[@class=\"summary_value_label\"][1]");
    private By shippingInformationValueLabel = By.xpath("//div[@class=\"summary_value_label\"][2]");
    private By itemTotalValueLabel = By.xpath("//div[@class=\"summary_subtotal_label\"]");
    private By taxValueLabel = By.xpath("//div[@class=\"summary_tax_label\"]");
    private By totalLabel = By.xpath("//div[@class=\"summary_info_label summary_total_label\"]");

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
    public String getPaymentInformationLabel() {
        return driver.findElement(paymentInformationLabel).getText();
    }
    public String getShippingInformationLabel() {
        return driver.findElement(shippingInformationLabel).getText();
    }
    public String getPriceSubtotalLabel() {
        return driver.findElement(priceSubtotalLabel).getText();
    }
    public String getPaymentInformationValue() {
        return driver.findElement(paymentInformationValueLabel).getText();
    }
    public String getShippingInformationValue() {
        return driver.findElement(shippingInformationValueLabel).getText();
    }
}
