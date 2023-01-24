package com.qaprosoft.carina.demo.utils;

import org.openqa.selenium.WebDriver;

import static com.qaprosoft.carina.core.foundation.utils.common.CommonUtils.pause;

public class PageSwitcher {
    private static String originalWindow;

    public static void SwitchForward(WebDriver driver) {
        originalWindow = driver.getWindowHandle();
//        assert driver.getWindowHandles().size() == 1;
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public static void SwitchBack(WebDriver driver) {
        driver.close();
        driver.switchTo().window(originalWindow);
        originalWindow="";
        driver.getWindowHandles().clear();
    }
}
