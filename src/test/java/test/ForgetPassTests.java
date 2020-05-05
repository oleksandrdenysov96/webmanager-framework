package test;

import com.example.test.common.AbstractTest;
import com.example.test.pages.ForgetPassPage;
import com.example.test.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgetPassTests extends AbstractTest {

    @Test
    public void testForgetPassUrlIsValid() {
        Assert.assertEquals(new HomePage(getDriver()).getPage().openLogInPage().forgetPass().getCurrentUrl(),
                new ForgetPassPage(getDriver()).getPageUrl());
    }
    @Test
    public void testPageHeader() {
        Assert.assertEquals((new HomePage(getDriver()).getPage().openLogInPage().forgetPass().
                getElement(new ForgetPassPage(getDriver()).pageHeader).getText()), "RESET YOUR PASSWORD");
    }
    @Test
    public void testFillTheFormWithUnregisteredEmail() {
        String email = "invalid@email.com";
        Assert.assertEquals(new HomePage(getDriver()).getPage().openLogInPage().forgetPass().fillTheFormWithUnregisteredEmail(email).
                getElement(new ForgetPassPage(getDriver()).unregisteredEmailPopup).getText(),
                "<strong>Email address isn't registered!</strong> Please check and try again");
    }
}
