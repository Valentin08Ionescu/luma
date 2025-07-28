package org.example.Steps;

import io.cucumber.java.en.Given;
import org.example.BasePage;
import org.example.PageObjects.MainPage;
import org.example.PageObjects.SignInPage;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class SignInSteps {
    private static WebDriver driver;
    private BasePage basePage;

    public SignInSteps() {
        if (driver == null) {
            basePage = new BasePage();
            driver = basePage.webDriver();
        } else {
            basePage = new BasePage(driver);
        }
    }


    @Given("the user clicks on the 'Create an Account' button")
    public void createAccountButton() {
        SignInPage signInPage = new SignInPage(driver);
        signInPage.createAccountButtonClick();
    }


}
