package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends BasePage {

    @FindBy (css="#newsletter-input")
    private WebElement newsletterEmailInput;
    @FindBy (css="[name='submitNewsletter']")
    private WebElement submitEmailButton;
    @FindBy (css=".alert-success")
    private WebElement successSubscribeMsg;
    @FindBy (css=".alert-danger")
    private WebElement failedSubscribeMsg;
    @FindBy (xpath="//a[contains(@href,'facebook')]")
    private WebElement facebook;
    @FindBy (xpath="//a[contains(@href,'twitter')]")
    private WebElement twitter;
    @FindBy (xpath="//a[contains(@href,'youtube')]")
    private WebElement youtube;
    @FindBy (xpath="//a[contains(@href,'google')]")
    private WebElement googlePlus;

    public Footer(WebDriver driver) {
        super(driver);
    }

    public void sendNewsletterEmail(String email) {
        fillText(newsletterEmailInput, email);
        click(submitEmailButton);
    }

    public String getSuccessSubscribeMsg(){
        waitForElementToBeVisible(successSubscribeMsg);
        return getText(successSubscribeMsg);
    }

    public String getFailedSubscribeMsg(){
        waitForElementToBeVisible(failedSubscribeMsg);
        return getText(failedSubscribeMsg);
    }

    public void goToSocialNetwork(String socialNetwork){

        switch (socialNetwork) {
            case "facebook":
                click(facebook);
                break;
            case "twitter":
                click(twitter);
                break;
            case "youtube":
                click(youtube);
                break;
            case "google plus":
                click(googlePlus);
                break;
        }
    }

    public void chooseFromCategories(String category){
        driver.findElement(By.partialLinkText(category)).click();
    }

    public void chooseFromInformation(String infoOption){
        driver.findElement(By.partialLinkText(infoOption)).click();
    }

    public void chooseFromMyAccount(String myAccountOption){
        driver.findElement(By.partialLinkText(myAccountOption)).click();
    }


}
