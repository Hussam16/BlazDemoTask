package tests;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
    private static WebDriver driver;
    

    private DriverFactory() {
        
    }

    public static WebDriver getDriver() {
        if (driver == null) {
        	WebDriverManager.firefoxdriver().setup();
    		 driver = new FirefoxDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
