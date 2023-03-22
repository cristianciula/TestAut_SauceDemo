package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import testdata.User;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //LOCATORS
    public By usernameInput = By.id("user-name");
    public By passwordInput = By.id("password");
    public By loginButton = By.id("login-button");

    //ACTIONS
    public boolean loginButtonIsDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
    public void enterUsername(String username) {
        driver.findElement(usernameInput).sendKeys(username);
    }
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public void authenticate(User user) {
        enterUsername(user.getUsername());
        enterPassword(user.getPassword());
        clickLogin();
    }
}
