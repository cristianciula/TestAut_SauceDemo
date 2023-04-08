package tests;

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

    public static Menu menu;
    public static Header header;
    public static CartPage cartPage;
    public static LoginPage loginPage;
    public static ProductsPage productsPage;
    public static ProductDetailsPage productDetailsPage;
    public static CheckoutInfoPage checkoutInfoPage;
    public static CheckoutOverviewPage checkoutOverviewPage;
    public static CheckoutCompletePage checkoutCompletePage;

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

        menu = new Menu(driver);
        header = new Header(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);

        driver.get(URL.LOGIN_PAGE);
        assertTrue(loginPage.loginButtonIsEnabled());
        assertEquals(LoginMessages.LOGIN_BUTTON_COLOR, loginPage.getLoginButtonColor());
        assertEquals(LoginMessages.USERNAME_PLACEHOLDER, loginPage.getUsernamePlaceholder());
        assertEquals(LoginMessages.PASSWORD_PLACEHOLDER, loginPage.getPasswordPlaceholder());
    }
    @AfterEach
    public void afterEach() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
