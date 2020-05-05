package test;

import com.example.test.common.AbstractTest;
import com.example.test.pages.HomePage;
import com.example.test.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends AbstractTest {

    @Test
    public void openRegistrationPageTest() {
        Assert.assertEquals(new HomePage(getDriver()).getPage().openRegisterPage().getElement(new RegistrationPage(getDriver()).
                registrationTitle).getText(), "REGISTRATION");
    }
    @Test
    public void submitResisterFormTest() {
        String userName = "alex";
        String email = "denisovalexsd@gmail.com";
        String password = "password";

        Assert.assertEquals(new HomePage(getDriver()).getPage().openRegisterPage().fillRegisterFields(userName, email, password).
                getElement(new RegistrationPage(getDriver()).registeredPopup).getText(),
                "<strong>Registration saved!</strong> Please check your email for confirmation.");
    }
}
