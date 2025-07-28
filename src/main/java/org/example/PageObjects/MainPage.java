package org.example.PageObjects;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "page-title-wrapper")
    private WebElement pageTitle;

    @FindBy(xpath = "//button[@aria-label='Consent']")
    private WebElement personalDataConsentButton;

    @FindBy(xpath = "//header//a[contains(text(), 'Sign In')]")
    private WebElement signInButton;

    @FindBy(xpath = "//header//a[contains(text(), 'Sign In')]")
    private WebElement productNameText;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@data-ui-id, 'success')]")
    private WebElement successMessage;


    @FindBy(xpath = "//a[text()='shopping cart']")
    private WebElement shoppingCartButton;


    String productNameLocator = "//a[@title='%s']";
    private WebElement productName(String xpathElement, String option) {
        By itemBy = By.xpath(String.format(xpathElement, option));
        return driver.findElement(itemBy);
    }

    String productSizeLocator = "//*[@option-label='%s']";
    private WebElement productSize(String xpathElement, String option) {
        By itemBy = By.xpath(String.format(xpathElement, option));
        return driver.findElement(itemBy);
    }

    String productColorLocator = "//*[@option-label='%s']";
    private WebElement productColor(String xpathElement, String option) {
        By itemBy = By.xpath(String.format(xpathElement, option));
        return driver.findElement(itemBy);
    }

    public void consentButtonClick() {
        personalDataConsentButton.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public void signInButtonClick() {
        signInButton.click();
    }

    public void productNameClick(String product) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productName(productNameLocator, product));
        productName(productNameLocator, product).click();
    }

    public void productSizeSelect(String size) {
        productSize(productSizeLocator, size).click();
    }

    public void productColorSelect(String color) {
        productSize(productColorLocator, color).click();
    }

    public void addToCartButtonClick() {addToCartButton.click();}

    public void shoppingCartButtonClick() {shoppingCartButton.click();}

    public boolean getSuccessMessage() {
        return successMessage.isDisplayed();
    }
}




