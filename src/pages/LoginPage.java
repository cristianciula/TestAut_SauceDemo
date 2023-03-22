package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
