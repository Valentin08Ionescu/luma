package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.lang.*;
import java.io.InputStream;
import java.util.Properties;

import java.io.IOException;

public class BasePage {
    // This class can be used as a base class for other classes in the package.
    // It can contain common properties or methods that can be inherited by subclasses.

    // Example property

    protected static WebDriver driver;


    public BasePage() {
        if (driver == null) {
            Properties props = getProperties();
            String chromePath = props.getProperty("chrome.driver.path", "target/classes/Drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", chromePath);

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
        }
    }


    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public WebDriver webDriver() {
        return driver;
    }
    public void closeWebdriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


    public Properties getProperties() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("Properties/config.properties")) {
            if (input != null) {
                props.load(input);
            } else {
                System.out.println("Config file not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }


}
