package tests;

import colors.LoginColors;
import components.Header;
import components.Menu;
import messages.LoginMessages;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;
import testdata.URL;
import testdata.User;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {
    WebDriver driver;

    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static ProductDetailsPage productDetailsPage;
    public static CartPage cartPage;
    public static CheckoutInfoPage checkoutInfoPage;
    public static Header header;
    public static Menu menu;

    public static User standardUser = new User("standardUser");

    @BeforeAll
    public static void setUp() {

    }
    @AfterAll
    public static void tearDown() {

    }
    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/resource/chromedriver");
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(co);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        header = new Header(driver);
        menu = new Menu(driver);

        driver.get(URL.LOGIN_PAGE);
        assertTrue(loginPage.loginButtonIsDisplayed());
        assertEquals(LoginColors.LOGIN_BUTTON_COLOR, loginPage.getLoginButtonColor());
        assertEquals(LoginMessages.USERNAME_PLACEHOLDER, loginPage.getUsernamePlaceholder());
        assertEquals(LoginMessages.PASSWORD_PLACEHOLDER, loginPage.getPasswordPlaceholder());
    }
    @AfterEach
    public void afterEach() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
