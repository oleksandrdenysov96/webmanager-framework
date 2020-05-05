package test;

import com.example.test.common.AbstractTest;
import com.example.test.pages.HomePage;
import com.example.test.pages.SettingsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SettingsPageTests extends AbstractTest {

    @Test
    public void testSettingsPageUrlIsValid() {
        String username = "user";
        String password = "user";
        Assert.assertEquals(new HomePage(getDriver())
                .getPage()
                .openLogInPage()
                .successLogInToAcc(username, password)
                .openSettingsPage().getCurrentUrl(), new SettingsPage(getDriver()).getPageUrl());
    }
    @Test
    public void testChangingAllSettings() {
        String username = "user";
        String password = "user";
        String newUserName = "Sasha";
        String newLastName = "Denysov";
        String email = "sasha@gmail.com";
        Assert.assertEquals(new HomePage(getDriver())
                .getPage()
                .openLogInPage()
                .successLogInToAcc(username, password)
                .openSettingsPage()
                .changeAllSettingsAndClickSave(newUserName, newLastName, email)
                .getElement(new SettingsPage(getDriver()).settingsSavedPopup).getText(), "<strong>Settings saved!</strong>");
    }
}
