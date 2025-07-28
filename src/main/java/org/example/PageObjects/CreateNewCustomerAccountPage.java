package org.example.PageObjects;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreateNewCustomerAccountPage extends BasePage {

    public CreateNewCustomerAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    private WebElement firstNameBox;

    @FindBy(id = "lastname")
    private WebElement lastNameBox;

    @FindBy(id = "email_address")
    private WebElement emailAdrressBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "password-confirmation")
    private WebElement passwordConfirmationBox;

    @FindBy(xpath = "//button[@title='Create an Account']")
    private WebElement createAnAccountButton;


    public void iFrameHandle() {
        // Switch to iframe by name or ID
        WebElement iframe = driver.findElement(By.xpath("/html/ins//iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("dismiss-button")).click();
        driver.switchTo().defaultContent();

    }

    public void firstNameInput(String string) {
        firstNameBox.sendKeys(string);
    }

    public void lastNameInput(String string) {
        lastNameBox.sendKeys(string);
    }

    public void emailInput(String string) {
        emailAdrressBox.sendKeys(string);

    }

    public void passwordInput(String string) {
        passwordBox.sendKeys(string);
    }

    public void passwordConfirmationInput(String string) {
        passwordConfirmationBox.sendKeys(string);
    }

    public void createAccountButtonClick() {
        createAnAccountButton.click();
    }
}
