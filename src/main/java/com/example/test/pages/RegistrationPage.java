package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends AbstractPage {

    // TODO: REFACTOR VIA 'FIND BY'

    public By registrationTitle = By.xpath("/html/body/div/div/div[2]/div[3]/div[1]/div/div/div[1]/div/h1");
    private By usernameField = By.id("username");
    private By emailField = By.id("email");
    private By newPassField = By.id("firstPassword");
    private By confirmNewPassField = By.id("secondPassword");
    private By registerButton = By.id("register-submit");
    public By registeredPopup = By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div[1]");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public RegistrationPage getPage() {
        getDriver().get(getPageUrl());
        return this;
    }
    public String getPageUrl() {
        return baseUrl + "register";
    }

    private void typeUsername(String username) {
        getElement(usernameField).sendKeys(username);
    }
    private void typeEmail(String email) {
        getElement(emailField).sendKeys(email);
    }
    private void typeNewPass(String password) {
        getElement(newPassField).sendKeys(password);
        getElement(confirmNewPassField).sendKeys(password);
    }
    public RegistrationPage fillRegisterFields(String username, String email, String password) {
        typeUsername(username);
        typeEmail(email);
        typeNewPass(password);
        clickElement(registerButton);
        return this;
    }
}
