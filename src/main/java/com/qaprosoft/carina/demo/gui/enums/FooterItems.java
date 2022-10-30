package com.qaprosoft.carina.demo.gui.components.enums;

public enum FooterItems {
    HOME(1, "Home"), NEWS(2, "News"), REVIEWS(3, "Reviews"), COMPARE(4, "Compare"),
    COVERAGE(5, "Coverage"), GLOSSARY(6, "Glossary"), FAQ(7, "FAQ"), RSS_FEED(8, "RSS feed"),
    YOUTUBE(9, "Youtube"), FACEBOOK(10, "Facebook"), TWITTER(10, "Twitter"), INSTAGRAM(11, "Instagram"),

//    GSMARENA(1, "GSMArena.com"),
    MOBILE_VERSION(2, "Mobile version"), ANDROID_APP(3, "Android app"), TOOLS(4, "Tools"),
    CONTACT_US(5, "Contact us"), MERCH_STORE(6, "Merch store"), PRIVACY(7, "Privacy"), TERMS_OF_USE(8, "Terms of use");

    private int number;
    private String name;

    FooterItems(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
