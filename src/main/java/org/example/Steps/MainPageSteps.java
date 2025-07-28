package org.example.Steps;

import io.cucumber.java.en.Given;
import org.example.BasePage;
import org.example.PageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import static org.assertj.core.api.Assertions.*;

public class MainPageSteps {
    private static WebDriver driver;
    private BasePage basePage;

    public MainPageSteps() {
        if (driver == null) {
            basePage = new BasePage();
            driver = basePage.webDriver();
        } else {
            basePage = new BasePage(driver);
        }
    }

    @Given("user navigates to the LUMA page")
    public void userNavigatesToThePage() {
        basePage.webDriver().navigate().to(basePage.getProperties().getProperty("baseUrl"));
        System.out.println("Navigating to basePage");
    }

    @Given("the page with the title {string} should be displayed")
    public void verifyTitle (String pageName) throws InterruptedException {
        assertThat(basePage.webDriver().getTitle()).isEqualTo(pageName);
    }

    @Given("the user clicks on the Sign In link")
    public void signInClick () {
        MainPage mainPage = new MainPage(driver);
        mainPage.signInButtonClick();

    } @Given("user clicks on the Consent button")
    public void consentButton () {
        MainPage mainPage = new MainPage(driver);
        mainPage.consentButtonClick();
    }

    @Given("user select the product with the name {string}, size {string}, color {string}")
    public void productSelection (String productName, String size, String color) {
        MainPage mainPage = new MainPage(driver);
        mainPage.productNameClick(productName);
        mainPage.productSizeSelect(size);
        mainPage.productColorSelect(color);
    }

    @Given("clicks on the Add to cart button")
    public void addToCartClick () {
        MainPage mainPage = new MainPage(driver);
        mainPage.addToCartButtonClick();
    }
    @Given("a success message should be displayed")
    public void messageVerify () throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        Thread.sleep(3000);
        assertThat(mainPage.getSuccessMessage()).isTrue();
    }

}
