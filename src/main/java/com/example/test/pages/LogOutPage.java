package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogOutPage extends AbstractPage {

    // TODO: REFACTOR VIA 'FIND BY'

    private By homeButton = By.xpath("/html/body/div/div/div[2]/div[2]/nav/div/ul/li[1]/a/span");
    private WebElement logOutString = getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div[3]/div[1]/div/div/h4"));

    public LogOutPage(WebDriver driver) {
        super(driver);
    }

    public LogOutPage getPage() {
        getDriver().get(getPageUrl());
        return this;
    }

    public String getPageUrl() {
        return baseUrl + "logout";
    }

    public HomePage goToHomePage() {
        clickElement(homeButton);
        return new HomePage(getDriver());
    }
    public WebElement getLogOutString() {
        return this.logOutString;
    }
}
