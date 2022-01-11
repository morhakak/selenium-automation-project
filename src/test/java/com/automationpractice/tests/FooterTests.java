package com.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTests extends BaseTest{

    @Test (description = "Choosing an option from categories")
    public void tc_01_chooseFromCategories() {

        footer.chooseFromCategories("Women");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Women - My Store");
    }

    @Test (description = "Choosing an option from information")
    public void tc_02_chooseFromInformation(){
        footer.chooseFromInformation("About us");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "About us - My Store");
    }

    @Test (description = "Choosing an option from my account")
    public void tc_03_chooseFromMyAccount(){
        footer.chooseFromInformation("My orders");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Login - My Store");
    }

    @Test (description = "Submit a new valid email for newsletter subscription")
    public void tc_04_successfulNewsletterSubscription(){
        footer.submitNewsletterEmail("test03@02test.com");
        String successMsg = footer.getAlertMessage();
        Assert.assertTrue(successMsg.toLowerCase().contains("successfully"));
    }

    @Test (description = "Submit an existing email for newsletter subscription")
    public void tc_05_failedNewsletterSubscription(){
        footer.submitNewsletterEmail("test03@02test.com");
        String successMsg = footer.getAlertMessage();
        Assert.assertTrue(successMsg.toLowerCase().contains("already registered"));
    }

    @Test (description = "Submit an invalid email for newsletter subscription")
    public void tc_06_invalidEmailSubscription(){
        footer.submitNewsletterEmail("test02.com");
        String alertMessage = footer.getAlertMessage();
        Assert.assertTrue(alertMessage.toLowerCase().contains("invalid email"));
    }

    @Test (description = "Navigate to facebook page")
    public void tc_07_navigateToFacebook(){
        footer.goToSocialNetwork("facebook");
        footer.switchWindows();
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.toLowerCase().contains("facebook"));
    }
}
