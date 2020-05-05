package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class LogInPage extends AbstractPage {

    // TODO: TO CONTINUE REFACTORING VIA 'FIND BY'

    @FindBy (id = "username")
    private WebElement userNameField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (css = ".btn-primary")
    private WebElement signInButton;

    @FindBy (css = "[href *= 'request']")
    private WebElement forgetPass;

    @FindBy (css = ".close")
    private WebElement closeButton;

    @FindBy (css = ".alert-danger")
    public WebElement failedLogIn;
    public By errorOnUserNamePopup = By.cssSelector("#root > div > div.app-container > div.Toastify > div > div > div.Toastify__toast-body");
    public By errorOnPasswordPopup = By.xpath("/html/body/div[1]/div/div[2]/div[1]/div/div/div[1]");

    public LogInPage(WebDriver driver) {
        super(driver);
    }
    public String getPageUrl() {
        return baseUrl + "login";
    }
    public LogInPage getPage() {
        getDriver().get(getPageUrl());
        return this;
    }
    private void typeUserName(String username) {
        userNameField.sendKeys(username);
    }
    private void typePassword(String password) {
        passwordField.sendKeys(password);
    }
    public HomePage successLogInToAcc(String username, String password) {
        typeUserName(username);
        typePassword(password);
        signInButton.click();
        new FluentWait<>(this)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .until((page) -> !page.isDialogDisplayed());
        return new HomePage(getDriver());
    }
    public LogInPage failedLogInToAcc(String invalidUserName, String invalidPass) {
        typeUserName(invalidUserName);
        typePassword(invalidPass);
        signInButton.click();
        return this;
    }
    public LogInPage typeOnlyUserNameAndClickLogIn(String userName) {
        typeUserName(userName);
        signInButton.click();
        return this;
    }
    public LogInPage typeOnlyPasswordAndClickLogIn(String password) {
        typePassword(password);
        signInButton.click();
        return this;
    }
    public ForgetPassPage forgetPass() { // TODO: refactor double click
        forgetPass.click();
        forgetPass.click();
        return new ForgetPassPage(getDriver());
    }
    public HomePage closeLoginPage() {
        closeButton.click();
        return new HomePage(getDriver());
    }
}
