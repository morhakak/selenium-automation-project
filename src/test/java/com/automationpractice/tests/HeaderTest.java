package com.automationpractice.tests;

import com.automationpractice.pageobjects.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {


    @Test(description = "Click on Login to the site")
    public void tc_01_clickOnSignIn() {
        header.clickOnSignIn();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login - My Store";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Click on contact")
    public void tc_02_clickOnContactUs() {

        header.clickOnContactUs();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Contact us - My Store";
        Assert.assertFalse(!actualTitle.equals(expectedTitle));
    }


    @Test(description = "Click on cart")
    public void tc_03_clickOnCart() {
        header.clickOnCart();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Order - My Store";
        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }

    @Test(description = "Validation on site number")
    public void tc_04_chooseItem() {
        String actualPhon = header.websitePhone();
        String expectedPhon = "0123-456-789";
        Assert.assertEquals(actualPhon, expectedPhon);
    }

    @Test(description = "Product search in the search field")
    public void tc_05_productSearch() {

        header.productSearch("T-SHIRTS");
        String actualTitle = driver.getTitle();
        String expectedTitle = "Search - My Store";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Return to the home page by clicking on the site's icon")
    public void tc_06_clickOnIconSite() {
        header.clickOnSignIn();
        header.clickOnIconSite();
        String actualHomePageTitle = driver.getTitle();
        String expectedHomePageTitle = "My Store";
        String pageTitle = driver.getTitle();
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        header.clickOnCart();
        header.clickOnIconSite();
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
        header.clickOnContactUs();
        header.clickOnIconSite();
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle);
    }

    @Test(description = "Choosing a product from women's clothing")
    public void tc_07_chooseItem() {
        header.productSelection(Header.topMenu.DRESSES);
        String pageTitle = driver.getTitle();
        header.sleep(15000);
        Assert.assertFalse(pageTitle == "Women - My Store");
    }
}
