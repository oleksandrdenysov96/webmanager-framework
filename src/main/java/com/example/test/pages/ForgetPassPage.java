package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPassPage extends AbstractPage {

    // TODO: REFACTOR VIA 'FIND BY'

    public By pageHeader = By.cssSelector("#app-view-container > div.jh-card.card > div > div > div > div > h1");
    public By unregisteredEmailPopup = By.cssSelector("#root > div > div.app-container > div.Toastify > div > div > div.Toastify__toast-body");
    private By emailField = By.name("email");
    private By resetPasswordButton = By.cssSelector("#app-view-container > div.jh-card.card > div > div > div > div > form > button");

    public ForgetPassPage(WebDriver driver) {
        super(driver);
    }
    public ForgetPassPage getPage() {
        getDriver().get(getPageUrl());
        return this;
    }
    public String getPageUrl() {
        return baseUrl + "account/reset/request";
    }
    public ForgetPassPage fillTheFormWithUnregisteredEmail(String email) {
        getElement(emailField).sendKeys(email);
        clickElement(resetPasswordButton);
        return this;
    }
}
