package com.automationpractice.tests;

import com.automationpractice.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    @Test(description = "Click on home slider")
    public void tc_01_clickOnHomeSlider() {
        homePage.clickOnHomeSlider();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Create and build your online store with PrestaShop";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(description = "Click on product title")
    public void tc_02_clickOnProductTitle() {
        homePage.clickOnProductTitle(HomePage.namProductTitles.SAVVY_TRENDS);
        String actualTitle = driver.getTitle();
        String homePageTitle = "My Store";
        Assert.assertTrue(actualTitle != homePageTitle);
    }

    @Test(description = "Click on add to cart by price")
    public void tc_03_clickOnAddToCartByPrice() {
        double price = 27.00;
        homePage.clickOnAddToCartByPrice(price);
        double totalPrice = homePage.validTotalPriceInCart();
        Assert.assertEquals(totalPrice , price + 2);
    }

    @Test(description = "Click on mor by price")
    public void tc_04_clickOnMorByPrice() {
        homePage.clickOnMorByPrice(16.40);
        String actualTitle = driver.getTitle();
        String homePageTitle = "My Store";
        Assert.assertTrue(actualTitle != homePageTitle);
    }
    @Test(description = "click on home items name by price")
    public void tc_05_clickOnHomeItemsNameByPrice() {
        homePage.clickOnHomeItemsNameByPrice(16.40);
        String actualTitle = driver.getTitle();
        String homePageTitle = "My Store";
        Assert.assertTrue(actualTitle != homePageTitle);
    }
    @Test(description = "Sort by best seller or popular")
    public void tc_06_SortByBestSellerOrPopular() {
        homePage.SortByBestsellerOrPopular(HomePage.typesOfSorting.BESTSELLER);
        //String actualTitle = driver.getTitle();
        //String homePageTitle = "My Store";
        //Assert.assertTrue(actualTitle != homePageTitle);
    }
}