package com.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTests extends BaseTest {


    @Test(description = "Send details in contact")
    public void tc_01_sendDetailsInContact() {
        header.clickOnContactUs();
        contactPage.fillContact("asdf ytre juut ", "Customer service", "654@gmail.com", "Hi", 1, 1, "C:\\a\\test.txt");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Contact us - My Store";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test(description = "fill contact page with invalid email")
    public void tc_02_invalidEmailInContactPage() {
        header.clickOnContactUs();
        contactPage.fillContact("asdf ytre juut ", "Customer service", "654mail.com", "Hi", 1, 1, "C:\\a\\test.txt");
        String expectedErrorMsg = "Invalid email address.";
        Assert.assertTrue(contactPage.isValidErrorMsg(expectedErrorMsg));
    }

    @Test(description = "fill contact page with empty message")
    public void tc_03_invalidEmailInContactPage() {
        header.clickOnContactUs();
        contactPage.fillContact("", "Webmaster", "654@mail.com", "Hi", 1, 1, "C:\\a\\test.txt");
        String expectedErrorMsg = "The message cannot be blank.";
        Assert.assertTrue(contactPage.isValidErrorMsg(expectedErrorMsg));
    }

    @Test(description = "fill contact page with empty subject heading")
    public void tc_04_invalidEmailInContactPage() {
        header.clickOnContactUs();
        contactPage.fillContact("asdf ytre juut ", "", "654@mail.com", "Hi", 1, 1, "C:\\a\\test.txt");
        String expectedErrorMsg = "Please select a subject from the list provided.";
        Assert.assertTrue(contactPage.isValidErrorMsg(expectedErrorMsg));
    }
}
