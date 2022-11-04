package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.HamburgerMenu;
import com.qaprosoft.carina.demo.gui.enums.FooterItems;
import com.qaprosoft.carina.demo.gui.enums.MenuItems;
import com.qaprosoft.carina.demo.gui.pages.HomePage;
import com.qaprosoft.carina.demo.utils.JavascriptCommands;
import com.qaprosoft.carina.demo.utils.PageFactory;
import com.qaprosoft.carina.demo.utils.PageSwitcher;
import com.zebrunner.agent.core.annotation.TestLabel;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebMainMenuClickTest implements IAbstractTest {
    @Test(description = "Test checks main menu buttons")
    @MethodOwner(owner = "Eugene")
    @TestLabel(name = "feature", value = {"web"})
    public void testMainMenuItems() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SoftAssert softAssert = new SoftAssert();
        HamburgerMenu hamburgerMenu = homePage.getTopBar().getHamburgerMenu();
        PageFactory factory = new PageFactory();
        for (MenuItems item : MenuItems.values()) {
            if (hamburgerMenu.getMenuItem(item.getNumber()).getElement().getAttribute("target").contains("blank")) {
                hamburgerMenu.getMenuItem(item.getNumber()).click();
                PageSwitcher.SwitchForward(getDriver());
                AbstractPage page = factory.mainMenuPage(item, getDriver());
                softAssert.assertTrue(page.isPageOpened(), "No page opened by click on " + item.name());
                PageSwitcher.SwitchBack(getDriver());
            } else {
                hamburgerMenu.getMenuItem(item.getNumber()).click();
                AbstractPage page = factory.mainMenuPage(item, getDriver());
                softAssert.assertTrue(page.isPageOpened(), "No page opened by click on " + item.name());
            }
        }
        softAssert.assertAll();
    }

    @Test(description = "Test checks footer menu links")
    @MethodOwner(owner = "Eugene")
    @TestLabel(name = "feature", value = {"web"})
    public void testFooterMenuItems() {
        WebDriver driver = getDriver();
        HomePage homePage = new HomePage(driver);
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        FooterMenu footerMenu = homePage.getFooterMenu();

        JavascriptCommands commands = new JavascriptCommands(driver);
        commands.scrollUntil(footerMenu.getFooterLink("Privacy").getElement());

        SoftAssert softAssert = new SoftAssert();
        PageFactory factory = new PageFactory();

        for (FooterItems item : FooterItems.values()) {
            if (!footerMenu.isUIObjectPresent() || !footerMenu.getFooterLink(item.getName()).isVisible()) {
                homePage.open();
                commands.scrollUntil(footerMenu.getFooterLink("Privacy").getElement());
            }
            AbstractPage page;
            if (footerMenu.getFooterLink(item.getName()).getElement().getAttribute("target").contains("blank")) {
                footerMenu.getFooterLink(item.getName()).click();
                PageSwitcher.SwitchForward(driver);
                page = factory.footerMenuPage(item, driver);
                softAssert.assertTrue(page.isPageOpened(), "No page opened by click on " + item.name());
                PageSwitcher.SwitchBack(driver);
            } else {
                footerMenu.getFooterLink(item.getName()).click();
                page = factory.footerMenuPage(item, driver);
                softAssert.assertTrue(page.isPageOpened(), "No page opened by click on " + item.name());
            }
        }
        softAssert.assertAll();
    }
}
