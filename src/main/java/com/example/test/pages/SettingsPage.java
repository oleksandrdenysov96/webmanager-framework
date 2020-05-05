package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends AbstractPage {

    // TODO: REFACTOR VIA 'FIND BY'

    public By settingsTitle = By.id("settings-title");
    public By settingsSavedPopup = By.cssSelector("#root > div > div.app-container > div.Toastify > div > div > div.Toastify__toast-body");
    private By firstNameField = By.id("firstName");
    private By lastNameField = By.id("lastName");
    private By emailField = By.id("email");
    private By saveButton = By.cssSelector("#settings-form > button");


    public SettingsPage(WebDriver driver) {
        super(driver);
    }
    public SettingsPage getPage() {
        getDriver().get(getPageUrl());
        return this;
    }
    public String getPageUrl() {
        return baseUrl + "account/settings";
    }
    private void clearField(By locator) {
        getElement(locator).clear();
    }
    private void setField(By fieldName, String data) {
        getElement(fieldName).sendKeys(data);
    }
    public SettingsPage changeAllSettingsAndClickSave(String firstName, String lastName, String email) {
        clearField(firstNameField);
        setField(firstNameField, firstName);
        clearField(lastNameField);
        setField(lastNameField, lastName);
        clearField(emailField);
        setField(emailField, email);
        clickElement(saveButton);
        return this;
    }
    public SettingsPage clearAllFieldsAndClickSave() {
        clearField(firstNameField);
        clearField(lastNameField);
        clearField(emailField);
        clickElement(saveButton);
        return this;
    }
}
