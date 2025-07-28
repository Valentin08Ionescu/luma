package org.example.Steps;

import io.cucumber.java.en.Given;
import org.example.BasePage;
import org.example.PageObjects.CreateNewCustomerAccountPage;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;


public class CreateNewCustomerAccountSteps {
    private static WebDriver driver;
    private BasePage basePage;

    public CreateNewCustomerAccountSteps() {
        if (driver == null) {
            basePage = new BasePage();
            driver = basePage.webDriver();
        } else {
            basePage = new BasePage(driver);
        }
    }


    @Given("the user enters valid account details")
    public void accountDetails() {
        String emailAccount =ThreadLocalRandom.current().nextInt(10, 1000) +basePage.getProperties().getProperty("email");
        CreateNewCustomerAccountPage createNewCustomerAccountPage = new CreateNewCustomerAccountPage(driver);
        createNewCustomerAccountPage.iFrameHandle();
        createNewCustomerAccountPage.firstNameInput(basePage.getProperties().getProperty("firstName"));
        createNewCustomerAccountPage.lastNameInput(basePage.getProperties().getProperty("lastName"));
        createNewCustomerAccountPage.emailInput(emailAccount);
        createNewCustomerAccountPage.passwordInput(basePage.getProperties().getProperty("password"));
        createNewCustomerAccountPage.passwordConfirmationInput(basePage.getProperties().getProperty("password"));
    }
    @Given("submits the registration form")
    public void createAnAccount() {
        CreateNewCustomerAccountPage createNewCustomerAccountPage = new CreateNewCustomerAccountPage(driver);
        createNewCustomerAccountPage.createAccountButtonClick();
    }


}
