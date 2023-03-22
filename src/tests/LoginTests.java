package tests;

import messages.LoginMessages;
import org.junit.jupiter.api.Test;
import testdata.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTests extends BaseTest {

    public static User wrongUser = new User("wrongUser");
    public static User lockedOutUseruser = new User("lockedOutUser");

    @Test
    public void validLogin() {
        loginPage.enterUsername(standardUser.getUsername());
        loginPage.enterPassword(standardUser.getPassword());
        loginPage.clickLogin();
    }

    @Test
    public void invalidLogin() {
        loginPage.enterUsername(wrongUser.getRandomUsername());
        loginPage.enterPassword(wrongUser.getPassword());
        loginPage.clickLogin();

        assertEquals(LoginMessages.INVALID_LOGIN_ERROR, loginPage.getErrorMessage());
    }

    @Test
    public void lockedUserLogin() {
        loginPage.enterUsername(lockedOutUseruser.getUsername());
        loginPage.enterPassword(lockedOutUseruser.getPassword());
        loginPage.clickLogin();

        assertEquals(LoginMessages.LOCKED_USER_LOGIN_ERROR, loginPage.getErrorMessage());
    }
}
