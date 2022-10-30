/*
 * Copyright 2013-2021 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TopBar extends AbstractUIObject {

    @FindBy(className = "login-icon")
    private ExtendedWebElement loginButton;
    @FindBy(className = "signup-icon")
    private ExtendedWebElement signUpButton;

    @FindBy(className = "lines-button")
    private ExtendedWebElement hamburgerButton;
    @FindBy(id = "login-popup2")
    private PopUp loginPopup;

    @FindBy(xpath = "//ul[@id='menu']")
    private HamburgerMenu HamburgerMenu;

    @FindBy(id = "logo")
    private ExtendedWebElement homeLink;

//    @FindBy(xpath = "//div[@class='footer-inner']//a[contains(text(),'Compare')]")
//    private ExtendedWebElement compareLink;
//
//    @FindBy(linkText = "News")
//    private ExtendedWebElement newsLink;

    public TopBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getLoginButton() {
        return loginButton;
    }

    public ExtendedWebElement getSignUpButton() {
        return signUpButton;
    }

    public ExtendedWebElement getHomeLink() {
        return homeLink;
    }

    public PopUp getLoginPopup() {
        loginButton.click();
        return loginPopup;
    }

    public HamburgerMenu getHamburgerMenu() {
        hamburgerButton.click();
        return HamburgerMenu;
    }

    public SignUpPage OpenSignUpPage () {
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public HomePage openHomePage() {
        homeLink.click();
        return new HomePage(driver);
    }

//    public CompareModelsPage openComparePage() {
//        compareLink.click();
//        return new CompareModelsPage(driver);
//    }
//
//    public NewsPage openNewsPage() {
//        newsLink.click();
//        return new NewsPage(driver);
//    }
}
