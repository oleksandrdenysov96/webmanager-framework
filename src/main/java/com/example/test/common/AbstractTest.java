package com.example.test.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class AbstractTest {

    private WebDriver driver;

    @BeforeClass
    public void setupDriver() {
        driver = createDriver();
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

    private WebDriver createDriver() {
        try {
            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        } catch (MalformedURLException e) {
            throw new RuntimeException("Failed to create driver", e);
        }
    }
    public WebDriver getDriver() {
        return driver;
    }
}
