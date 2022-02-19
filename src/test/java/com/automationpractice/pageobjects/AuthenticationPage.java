package com.automationpractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends Header{

    @FindBy (css = "#email_create")
    private WebElement CreateAccountEmailInput;
    @FindBy (css = "#SubmitCreate")
    private WebElement submitEmailAccountBtn;
    @FindBy (css = "#email")
    private WebElement registeredEmailInput;
    @FindBy (css = "#passwd")
    private WebElement registeredPasswordInput;
    @FindBy (xpath = "//a[contains(text(),'password')]")
    private WebElement forgotPasswordLink;
    @FindBy (css = "#SubmitLogin")
    private WebElement signInBtn;
    @FindBy (xpath = "//a[@title='Return to Home']")
    private WebElement returnHomeBtn;
    @FindBy (xpath = "//div[@id='create_account_error']//li")
    private WebElement createAccountErrorMsg;
    @FindBy (xpath = "//div[@class='alert alert-danger']//li")
    private WebElement registeredErrorMsg;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyLandingOnLoginPage() {
        String pageTitle = driver.getTitle();
        if (pageTitle.toLowerCase().contains("login")) {
            return true;
        } else {
            return false;
        }
    }

    public void returnToHomePage() {
        clickOnIconSite();
    }

    public void enterCreateEmail(String email) {
        fillText(CreateAccountEmailInput, email);
        click(submitEmailAccountBtn);
    }

    public String getCreateAccountErrorMsg() {
        return getText(createAccountErrorMsg);
    }

    public void signIn(String email, String password) {
        fillText(registeredEmailInput, email);
        fillText(registeredPasswordInput, password);
        click(signInBtn);
    }

    public void clickOnForgotPassword() {
        click(forgotPasswordLink);
    }

    public String getLoginErrorMsg() {
        return getText(registeredErrorMsg);
    }


}
