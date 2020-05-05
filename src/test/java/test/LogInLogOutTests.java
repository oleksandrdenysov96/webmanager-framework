package test;

import com.example.test.common.AbstractTest;
import com.example.test.pages.ForgetPassPage;
import com.example.test.pages.LogInPage;
import com.example.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInLogOutTests extends AbstractTest {


    @Test
    public void testLogInLogOut() {
        String userName = "user";
        String password = "user";

        Assert.assertEquals(new HomePage(getDriver())
                .getPage()
                .openLogInPage()
                .successLogInToAcc(userName, password)
                .logOutFromAcc().getLogOutString().getText(), "LOGGED OUT SUCCESSFULLY!");
    }

    @Test
    public void testLogInToTheSystemAsAdmin() {
        String adminUserName = "admin";
        String adminPassword = "admin";
        String expectedStringForAdminLoggedIn = "You are logged in as user admin.";

        Assert.assertEquals(new HomePage(getDriver())
                .getPage()
                .openLogInPage()
                .successLogInToAcc(adminUserName, adminPassword)
                .loggedAsAdmin
                .getText(), expectedStringForAdminLoggedIn);
        new HomePage(getDriver()).logOutFromAcc();
    }

    @Test
    public void testLogInWithInvalidCredentials() {
        String invalidCredentials = "invalid";

        Assert.assertEquals(new HomePage(getDriver())
                        .getPage()
                        .openLogInPage()
                        .failedLogInToAcc(invalidCredentials, invalidCredentials)
                        .failedLogIn.getText(),
                "Failed to sign in! Please check your credentials and try again.");
    }

    @Test
    public void testErrorOnUsernamePopup() {
        String password = "user";

        Assert.assertEquals(new HomePage(getDriver())
                .getPage()
                .openLogInPage()
                .typeOnlyPasswordAndClickLogIn(password)
                .getElement(new LogInPage(getDriver()).errorOnUserNamePopup).getText(), "Error on field \"Username\"");
    }

    @Test
    public void testErrorOnPasswordPopup() {
        String userUserName = "user";

        Assert.assertEquals(new HomePage(getDriver())
                .getPage()
                .openLogInPage()
                .typeOnlyUserNameAndClickLogIn(userUserName)
                .getElement(new LogInPage(getDriver()).errorOnPasswordPopup).getText(), "Error on field \"Password\"");
    }

    @Test
    public void testForgetPasswordPage() {
        Assert.assertEquals(new HomePage(getDriver())
                .getPage()
                .openLogInPage()
                .forgetPass()
                .getElement(new ForgetPassPage(getDriver()).pageHeader).getText(), "RESET YOUR PASSWORD");

    }
}
