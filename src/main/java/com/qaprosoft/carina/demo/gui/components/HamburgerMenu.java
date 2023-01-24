package com.qaprosoft.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HamburgerMenu extends AbstractUIObject {

    @FindBy(xpath = "(//ul[@id='menu']/li)[%s]/a")
    private ExtendedWebElement menuItem;

    public HamburgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getMenuItem(int item) {
        return menuItem.format(item);
    }
}
