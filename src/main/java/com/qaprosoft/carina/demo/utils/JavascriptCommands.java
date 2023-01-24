package com.qaprosoft.carina.demo.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.qaprosoft.carina.core.foundation.utils.common.CommonUtils.pause;

public class JavascriptCommands {
    JavascriptExecutor js;

    public JavascriptCommands(WebDriver driver) {
        this.js = (JavascriptExecutor) driver;
    }

    public void scrollUntil(WebElement element) {
        while (!element.isDisplayed()) {
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            pause(0.3);
        }
    }
}
