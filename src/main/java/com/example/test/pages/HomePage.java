package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy (id = "account-menu")
    private WebElement accountTab;

    @FindBy (css = "#login-item")
    private WebElement signInButton;

    @FindBy (css = ".dropdown-item[href *= 'logout']")
    private WebElement logOutButton;

    @FindBy (css = ".dropdown-item[href *= 'register']")
    private WebElement registerButton;

    @FindBy (css = ".nav-link[href = '/']")
    private WebElement homePageButton;

    @FindBy (css = ".dropdown-item[href *= 'settings']")
    private WebElement settingsPageButton;

    @FindBy (css = ".alert-success")
    public WebElement loggedAsAdmin;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage getPage() {
        getDriver().get(getPageUrl());
        return this;
    }
    public String getPageUrl() {
        return baseUrl;
    }
    public LogInPage openLogInPage() {
        accountTab.click();
        signInButton.click();
        return new LogInPage(getDriver());
    }
    public LogOutPage logOutFromAcc() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]")));
        accountTab.click();
        logOutButton.click();
        return new LogOutPage(getDriver());
    }
    public HomePage openHomePage() {
        homePageButton.click();
        return new HomePage(getDriver());
    }
    public RegistrationPage openRegisterPage() {
        accountTab.click();
        registerButton.click();
        return new RegistrationPage(getDriver());
    }
    public SettingsPage openSettingsPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[1]")));
        accountTab.click();
        settingsPageButton.click();
        return new SettingsPage(getDriver());
    }
}
