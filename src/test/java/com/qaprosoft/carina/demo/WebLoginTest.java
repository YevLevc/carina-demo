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

public class WebLoginSignUpTest implements IAbstractTest {

    @Test(description = "Test checks login modal")
    @MethodOwner(owner = "Eugene")
    @TestLabel(name = "feature", value = {"web"})
    public void testLoginModal() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        TopBar topBar = homePage.getTopBar();
        Assert.assertTrue(topBar.isUIObjectPresent(), "Top bar is not present!");

        PopUp popUp = homePage.getTopBar().getLoginPopup();

        String textMail = "test-mail";
        String textPass = "test-password";
        String color = "213, 0, 0";

        SoftAssert softAssert = new SoftAssert();
        popUp.getLoginButton().hover();
        pause(1);
        softAssert.assertTrue(popUp.getLoginButton().getElement().getCssValue("background-color").contains(color), "No");
        softAssert.assertTrue(popUp.getLoginButton().isClickable(), "Not clickable");
        softAssert.assertEquals(popUp.getPopUpTitle().getText().toLowerCase(), "login", "Title not as expected");
        softAssert.assertTrue(popUp.tryEnterLoginText(textMail, textPass), "Mail or pass cannot be entered");
        softAssert.assertTrue(popUp.getIForgotLink().isClickable(), "I forgot is not present or clickable");
        softAssert.assertAll();
    }

    @Test(description = "Testing login process")
    @MethodOwner(owner = "Eugene")
    @TestLabel(name = "feature", value = {"web"})
    public void testLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        String email = "john_tak_@ukr.net";
        String password = "john_tak_";

        LoggedinPage loggedinPage = homePage.getTopBar().getLoginPopup().login(email, password);
        Assert.assertTrue(loggedinPage.getLoginResult().getText().toLowerCase().contains("login successful"), "Login unsuccessful");
    }

    @Test(description = "Testing login modal forms", dataProvider = "create", dataProviderClass = DataProviderObjects.class)
    @MethodOwner(owner = "Eugene")
    @TestLabel(name = "feature", value = {"web"})
    public void testLogin(String email, String pass, String expectedEmail, String expectedPass) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        TopBar topBar = homePage.getTopBar();
        LoggedinPage loggedinPage = homePage.getTopBar().getLoginPopup().login(email, pass);

        if (!loggedinPage.isPageOpened()) {
            Assert.assertTrue(topBar.getLoginPopup().getEmailTextField().getElement().getAttribute("validationMessage").contains(expectedEmail), "Wrong message");
            Assert.assertTrue(topBar.getLoginPopup().getPasswordTextField().getElement().getAttribute("validationMessage").contains(expectedPass), "Wrong message");
        } else {
            if (expectedEmail.equals("correct")) {
                Assert.assertTrue(loggedinPage.getLoginMessage().getText().contains(expectedPass), "Wrong 'login failed' message");
            } else {
                Assert.assertTrue(loggedinPage.getLoginMessage().getText().contains(expectedEmail), "Wrong 'login failed' message");
            }
        }
    }
}
