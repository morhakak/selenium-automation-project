package com.automationpractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Header{

    @FindBy (xpath = "//h3[contains(text(),'personal')]")
    private WebElement personalInfoHeading;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public String getPersonalInfoHeading() {
        return getText(personalInfoHeading);
    }
}
