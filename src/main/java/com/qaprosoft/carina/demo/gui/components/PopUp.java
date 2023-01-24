package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.LoggedinPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PopUp extends AbstractUIObject {
    @FindBy(xpath = "(//input[@id='email'])[1]")
    private ExtendedWebElement emailTextField;

    @FindBy(xpath = "(//input[@id='upass'])[1]")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "(//input[@id='nick-submit'])[1]")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//*[@id='login-popup2']/form/p")
    private ExtendedWebElement popUpTitle;

    @FindBy(className = "forgot")
    private ExtendedWebElement iForgotLink;


    public PopUp(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getEmailTextField() {
        return emailTextField;
    }

    public ExtendedWebElement getPasswordTextField() {
        return passwordTextField;
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public ExtendedWebElement getPopUpTitle() {
        return popUpTitle;
    }

    public ExtendedWebElement getIForgotLink() {
        return iForgotLink;
    }

    public boolean tryEnterLoginText(String login, String password) {
//        loginButton.click();
//        String text = Randomizer.getAlphaNumericString(6);
        try {
            emailTextField.type(login);
            passwordTextField.type(password);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public LoggedinPage login(String login, String password) {
//        loginButton.click();
//        String text = Randomizer.getAlphaNumericString(6);
        tryEnterLoginText(login,password);
        loginButton.click();
        return new LoggedinPage(driver);
    }
}
