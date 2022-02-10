package com.automationpractice.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Footer extends BasePage {

    public static enum SocialNetworkEnum {
        FACEBOOK,
        TWITTER,
        YOUTUBE,
        GOOGLE
    }

    @FindBy (css="#newsletter-input")
    private WebElement newsletterEmailInput;
    @FindBy (css="[name='submitNewsletter']")
    private WebElement submitEmailButton;
    @FindBy (css=".alert")
    private WebElement alertMessage;
    @FindBy (xpath="//section[@id='block_contact_infos']//li[1]")
    private WebElement storeLocation;
    @FindBy (xpath="//section[@id='block_contact_infos']//li//span[contains(text(),'466')]")
    private WebElement storePhoneNumber;
    @FindBy (xpath="//section[@id='block_contact_infos']//li//span/a")
    private WebElement storeEmail;


    public Footer(WebDriver driver) {
        super(driver);
    }

    public void submitNewsletterEmail(String email) {
        fillText(newsletterEmailInput, email);
        click(submitEmailButton);
    }

    public String getAlertMessage(){
        return getText(alertMessage);
    }

    public void goToSocialNetworks(SocialNetworkEnum socialNetwork){

        List<WebElement> socialNetworks = driver.findElements(By.xpath("//section[@id='social_block']//ul//li//a"));
        switch (socialNetwork) {
            case FACEBOOK:
                click(socialNetworks.get(0));
                break;
            case TWITTER:
                click(socialNetworks.get(1));
                break;
            case YOUTUBE:
                click(socialNetworks.get(2));
                break;
            case GOOGLE:
                click(socialNetworks.get(3));
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

    public String getStoreLocation(){
        return getText(storeLocation);
    }

    public String getStorePhoneNumber(){
        return getText(storePhoneNumber);
    }

    public String getStoreEmail(){
        return getText(storeEmail);
    }

}
