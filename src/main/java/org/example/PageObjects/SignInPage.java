package org.example.PageObjects;

import org.example.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailBox;

    @FindBy(id = "pass")
    private WebElement passwordBox;

    @FindBy(xpath = "//button[@class='action login primary']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='action create primary']")
    private WebElement createAccountButton;

    public void emailBoxInput() {
        emailBox.sendKeys();    }

    public void createAccountButtonClick() {
        createAccountButton.click();
    }
}
