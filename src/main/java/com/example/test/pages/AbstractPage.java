package com.example.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    private final WebDriver driver;
    public static final String baseUrl = "http://localhost:8080/";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // TODO: TRY WITH SINGLETONE

    public WebDriver getDriver() {
        return driver;
    }

    public abstract AbstractPage getPage();

    public abstract String getPageUrl();

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public WebElement getElement(By locator) {
        return waitForElement(locator);
    }

    // --------
    // DEPRECATED? TODO: REFACTOR
    void clickElement(By locator) {
        WebElement wait = new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(locator));
        wait.click();
    }
    // --------

    private WebElement waitForElement(By locator) {
        WebElement wait;
        wait = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
        return wait;
    }
    public boolean isDialogDisplayed() {
        try {
            return driver.findElement(By.cssSelector("[role = dialog]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
