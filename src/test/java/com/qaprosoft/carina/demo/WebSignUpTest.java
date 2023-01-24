package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.components.PopUp;
import com.qaprosoft.carina.demo.gui.components.TopBar;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.gui.pages.LoggedinPage;
import com.qaprosoft.carina.demo.gui.pages.SignUpPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebSignUpTest implements IAbstractTest {

    @Test(description = "Testing sign up process")
    @MethodOwner(owner = "Eugene")
    @TestLabel(name = "feature", value = "web")
    public void testSignUp() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SignUpPage signUpPage = homePage.getTopBar().OpenSignUpPage();
        Assert.assertTrue(signUpPage.isPageOpened(), "Sign Up page is not opened!");
        signUpPage.signUp();
        Assert.assertTrue(signUpPage.getRegistrationSuccess().getText().contains("account was created"), "Registration unsuccessful");
    }
}
