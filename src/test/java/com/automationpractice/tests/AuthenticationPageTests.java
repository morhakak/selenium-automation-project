package com.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AuthenticationPageTests extends BaseTest {


    @Test (description = "Verify landing on Authentication page")
    public void tc_verifyAuthenticationPage() {
        header.clickOnSignIn();
        Assert.assertTrue(authenticationPage.verifyLandingOnHomePage());
    }

    @Test (description = "Verify returning to home page")
    public void tc_verifyReturnToHomePage() {
        header.clickOnSignIn();
        authenticationPage.returnToHomePage();
        Assert.assertTrue(driver.getTitle().contains("My Store"));
    }

    @Test (description = "Enter new and valid email")
    public void tc_enterValidEmail() {
        header.clickOnSignIn();
        authenticationPage.enterCreateEmail("test1715@test.com");
        String registerPageInfoHeading = registerPage.getPersonalInfoHeading();
        Assert.assertEquals(registerPageInfoHeading, "YOUR PERSONAL INFORMATION");
    }

    @Test (description = "Enter invalid email in create an account section")
    public void tc_enterInvalidEmail() {
        header.clickOnSignIn();
        authenticationPage.enterCreateEmail("test.test");
        String errorMsg = authenticationPage.getCreateAccountErrorMsg();
        Assert.assertTrue(errorMsg.toLowerCase().contains("invalid email"));
    }

    @Test (description = "Enter an existing email in create an account section")
    public void tc_enterExistingEmail() {
        header.clickOnSignIn();
        authenticationPage.enterCreateEmail("test@test.com");
        String errorMsg = authenticationPage.getCreateAccountErrorMsg();
        Assert.assertTrue(errorMsg.toLowerCase().contains("already been registered"));
    }

    @Test (dataProvider = "invalidEmailData", description = "Sign in with invalid email and valid password")
    public void tc_signInWithInvalidEmail(String email, String password) {
        header.clickOnSignIn();
        authenticationPage.signIn(email,password);
        String errorMsg = authenticationPage.getRegisteredErrorMsg();
        Assert.assertTrue(errorMsg.toLowerCase().contains("invalid email"));
    }

    @Test (dataProvider = "invalidPasswordData", description = "Sign in with invalid password and valid email")
    public void tc_signInWithInvalidPassword(String email, String password) {
        header.clickOnSignIn();
        authenticationPage.signIn(email,password);
        String errorMsg = authenticationPage.getRegisteredErrorMsg();
        Assert.assertTrue(errorMsg.toLowerCase().contains("invalid password") ||
                                    errorMsg.toLowerCase().contains("password is required"));
    }

    @DataProvider
    public Object[][] invalidEmailData(){
        Object[][] invalidEmail = {
                {"@","123"},
                {"test.test","123"},
                {"123","1#444"},
                {"test","123456878"},
        };
        return invalidEmail;
    }

    @DataProvider
    public Object[][] invalidPasswordData(){
        Object[][] invalidPassword = {
                {"test@test.com","1"},
                {"test@test.com","@"},
                {"test@test.com",""},
                {"test@test.com","1234"},
        };
        return invalidPassword;
    }
}
