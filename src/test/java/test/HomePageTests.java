package test;

import com.example.test.common.AbstractTest;
import com.example.test.pages.HomePage;
import com.example.test.pages.LogInPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends AbstractTest {

    @Test
    public void homePageOpening() {
        Assert.assertEquals(new HomePage(getDriver()).getPage().getCurrentUrl(), new HomePage(getDriver()).getPageUrl());
    }
    @Test
    public void testHomeButton() {
        Assert.assertEquals(new HomePage(getDriver()).getPage().openHomePage().getCurrentUrl(), new HomePage(getDriver()).getPageUrl());
    }
    @Test
    public void testSignInButton() {
        Assert.assertEquals(new HomePage(getDriver()).getPage().openLogInPage().getCurrentUrl(), new LogInPage(getDriver()).getPageUrl());
    }
}
