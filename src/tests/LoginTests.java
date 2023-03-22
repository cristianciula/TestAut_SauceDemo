package tests;

import org.junit.jupiter.api.Test;
import testdata.User;

public class LoginTests extends BaseTest {

    public static User wrongUser = new User("wrongUser");
    public static User lockedOutUseruser = new User("lockedOutUser");

    @Test
    public void login() {
        loginPage.enterUsername(standardUser.getUsername());
        loginPage.enterPassword(standardUser.getPassword());
        loginPage.clickLogin();
    }
}
