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
package com.qaprosoft.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.utils.Randomizer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends AbstractPage {

    @FindBy(id = "uname")
    private ExtendedWebElement nicknameTextField;

    @FindBy(xpath = "(//input[@id='email'])[2]")
    private ExtendedWebElement emailTextField;

    @FindBy(xpath = "(//input[@id='upass'])[2]")
    private ExtendedWebElement passwordTextField;

    @FindBy(xpath = "(//input[@id='nick-submit'])[2]")
    private ExtendedWebElement submitButton;

    @FindBy(xpath = "//label[@for='iagree1']")
    private ExtendedWebElement checkBoxStoreButton;

    @FindBy(xpath = "//label[@for='iagree2']")
    private ExtendedWebElement checkBoxOldButton;

    @FindBy(className = "res-success")
    private ExtendedWebElement registrationSuccess;

//    @FindBy(xpath="//div[@class='news-item']")
//    private List<NewsItem> news;


    public ExtendedWebElement getRegistrationSuccess() {
        return registrationSuccess;
    }

    public ExtendedWebElement getNicknameTextField() {
        return nicknameTextField;
    }

    public ExtendedWebElement getEmailTextField() {
        return emailTextField;
    }

    public ExtendedWebElement getPasswordTextField() {
        return passwordTextField;
    }

    public ExtendedWebElement getSubmitButton() {
        return submitButton;
    }

    public SignUpPage(WebDriver driver) {
        super(driver);
        setPageURL("/register.php3");
    }

    public void signUp() {
        String text = Randomizer.getAlphaNumericString(6);
        nicknameTextField.type(text);
        emailTextField.type(text+"@ukr.net");
        passwordTextField.type(text);
        checkBoxStoreButton.check();
        checkBoxOldButton.check();
        submitButton.click();
    }
    
}
