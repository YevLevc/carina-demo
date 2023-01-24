package com.qaprosoft.carina.demo;

import org.testng.annotations.DataProvider;

public class DataProviderObjects {
    @DataProvider(name = "incorrect")
    public static Object[][] createData() {
        return new Object[][]{
                new Object[]{"", "", "Заповніть це поле", "Заповніть це поле"},
                new Object[]{"incorrect@", "", "Введіть частину електронної", "Заповніть це поле"},
                new Object[]{"", "pass", "Заповніть це поле", "Виберіть потрібний формат"},
                new Object[]{"incorrect@", "pass", "Введіть частину електронної", "Виберіть потрібний формат"},
                new Object[]{"john_tak_ukr.net", "john_tak_", "адреса має містити знак",""},
//                new Object[]{"john_tak_@ukr.net", "ohn_tak_", "correct", "Wrong password"},
//                new Object[]{"tak@ukr.net", "john_tak_", "User record not found", "correct"},
        };
    }
}
