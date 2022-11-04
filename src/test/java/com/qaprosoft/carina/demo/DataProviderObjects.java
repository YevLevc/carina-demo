package com.qaprosoft.carina.demo;

import org.testng.annotations.DataProvider;

public class DataProviderObjects {
    @DataProvider (name = "create")
    public static Object[][] createData() {
        return new Object[][] {
                new Object[] { new Integer(42) }
        };
    }

}
