package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import testdata.URL;
import testdata.User;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BaseTest {
    WebDriver driver;

    public static LoginPage loginPage;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);

        driver.get(URL.LOGIN_PAGE);
        assertTrue(loginPage.loginButtonIsDisplayed());
    }
    @AfterEach
    public void afterEach() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
