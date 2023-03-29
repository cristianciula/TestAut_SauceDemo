package tests;

import colors.LoginColors;
import messages.LoginMessages;
import messages.ProductsMessages;
import org.junit.jupiter.api.Test;
import testdata.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    public static User wrongUser = new User("wrongUser");
    public static User lockedOutUser = new User("lockedOutUser");

    @Test
    public void validLogin() {
        loginPage.enterUsername(standardUser.getUsername());
        loginPage.enterPassword(standardUser.getPassword());
        loginPage.clickLogin();

        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        assertTrue(header.shoppingCartButtonIsDisplayed());
        assertTrue(header.menuButtonIsDisplayed());
    }

    @Test
    public void invalidUserLogin() {
        loginPage.enterUsername(wrongUser.getRandomUsername());
        loginPage.enterPassword(wrongUser.getPassword());
        loginPage.clickLogin();

        assertEquals(LoginMessages.INVALID_USER_LOGIN_ERROR, loginPage.getErrorMessage());
        assertEquals(LoginColors.LOGIN_ERROR_BACKGROUND_COLOR, loginPage.getErrorBackgroundColor());
    }

    @Test
    public void lockedOutUserLogin() {
        loginPage.enterUsername(lockedOutUser.getUsername());
        loginPage.enterPassword(lockedOutUser.getPassword());
        loginPage.clickLogin();

        assertEquals(LoginMessages.LOCKED_USER_LOGIN_ERROR, loginPage.getErrorMessage());
        assertEquals(LoginColors.LOGIN_ERROR_BACKGROUND_COLOR, loginPage.getErrorBackgroundColor());
    }

    @Test
    public void emptyCredentialsLogin() {
        loginPage.clickLogin();

        assertEquals(LoginMessages.MISSING_USERNAME_ERROR, loginPage.getErrorMessage());
        assertEquals(LoginColors.LOGIN_ERROR_BACKGROUND_COLOR, loginPage.getErrorBackgroundColor());
    }

    @Test
    public void emptyPasswordLogin() {
        loginPage.enterUsername(standardUser.getUsername());
        loginPage.clickLogin();

        assertEquals(LoginMessages.MISSING_PASSWORD_ERROR, loginPage.getErrorMessage());
        assertEquals(LoginColors.LOGIN_ERROR_BACKGROUND_COLOR, loginPage.getErrorBackgroundColor());
    }

    @Test
    public void logout() {
        loginPage.authenticate(standardUser);
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        assertTrue(header.shoppingCartButtonIsDisplayed());
        assertTrue(header.menuButtonIsDisplayed());

        header.clickMenu();
        assertTrue(header.menuSidebarIsDisplayed());
        assertTrue(header.logoutButtonIsDisplayed());

        header.clickLogout();
        assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
