package com.qaprosoft.carina.demo.gui.components.enums;

public enum MenuItems {
    HOME(1, "Home"), NEWS(2, "News"), REVIEWS(3, "Reviews"), VIDEOS(4, "Videos"),
    FEATURED(5, "Featured"), PHONE_FINDER(6, "Phone finder"), DEALS(7, "Deals"),
    MERCH(8, "Merch"), COVERAGE(9, "Coverage"), CONTACT(10, "Contact");

    private int number;
    private String name;

    MenuItems(int number, String name) {
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
