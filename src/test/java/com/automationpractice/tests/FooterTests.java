package com.automationpractice.tests;

import com.automationpractice.pageobjects.Footer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FooterTests extends BaseTest{

    @Test (description = "Choosing an option from categories")
    public void tc_01_chooseFromCategories() {

        footer.chooseFromCategories("Women");
        Assert.assertEquals(driver.getTitle(), "Women - My Store");
    }

    @Test (description = "Choosing an option from information")
    public void tc_02_chooseFromInformation(){
        footer.chooseFromInformation("About us");
        Assert.assertEquals(driver.getTitle(), "About us - My Store");
    }

    @Test (description = "Choosing an option from my account")
    public void tc_03_chooseFromMyAccount(){
        footer.chooseFromInformation("My orders");
        Assert.assertEquals(driver.getTitle(), "Login - My Store");
    }

    @Test (description = "Submit a new valid email for newsletter subscription")
    public void tc_04_successfulNewsletterSubscription(){
        footer.submitNewsletterEmail("test03@02test.com");
        Assert.assertTrue(footer.getAlertMessage().toLowerCase().contains("successfully"));
    }

    @Test (description = "Submit an existing email for newsletter subscription")
    public void tc_05_failedNewsletterSubscription(){
        footer.submitNewsletterEmail("test03@02test.com");
        Assert.assertTrue(footer.getAlertMessage().toLowerCase().contains("already registered"));
    }

    @Test (description = "Submit an invalid email for newsletter subscription")
    public void tc_06_invalidEmailSubscription(){
        footer.submitNewsletterEmail("test02.com");
        Assert.assertTrue(footer.getAlertMessage().toLowerCase().contains("invalid email"));
    }

    @Test (description = "Navigate to facebook page")
    public void tc_07_navigateToSocialNetwork(){
        footer.goToSocialNetworks(Footer.SocialNetworkEnum.TWITTER);
        footer.switchWindows();
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("twitter"));

    }

    @Test (description = "Verify store location")
    public void tc_08_verifyStoreLocation(){
        String storeLocation = footer.getStoreLocation();
        Assert.assertEquals(storeLocation, "Selenium Framework, Research Triangle Park, North Carolina, USA");
    }

    @Test (description = "Verify store phone number")
    public void tc_09_verifyStorePhoneNumber(){
        String storeLocation = footer.getStorePhoneNumber();
        Assert.assertEquals(storeLocation, "(347) 466-7432");
    }

    @Test (description = "Verify store email")
    public void tc_10_verifyStoreEmail(){
        String storeLocation = footer.getStoreEmail();
        Assert.assertEquals(storeLocation, "support@seleniumframework.com");
    }

}
