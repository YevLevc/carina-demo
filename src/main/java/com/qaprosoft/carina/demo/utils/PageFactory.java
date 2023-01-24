package com.qaprosoft.carina.demo.utils;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.enums.FooterItems;
import com.qaprosoft.carina.demo.gui.enums.MenuItems;
import com.qaprosoft.carina.demo.gui.pages.*;
import com.qaprosoft.carina.demo.gui.pages.external.*;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    public AbstractPage mainMenuPage(MenuItems item, WebDriver driver) {
        AbstractPage page = null;
        switch (item) {
            case HOME:
                page = new HomePage(driver);
                break;
            case NEWS:
                page = new NewsPage(driver);
                break;
            case REVIEWS:
                page = new ReviewsPage(driver);
                break;
            case VIDEOS:
                page = new VideosPage(driver);
                break;
            case FEATURED:
                page = new FeaturedPage(driver);
                break;
            case PHONE_FINDER:
                page = new PhoneFinderPage(driver);
                break;
            case DEALS:
                page = new DealsPage(driver);
                break;
            case MERCH:
                page = new MerchPage(driver);
                break;
            case COVERAGE:
                page = new CoveargePage(driver);
                break;
            case CONTACT:
                page = new ContactPage(driver);
                break;
        }
        return page;
    }
    public AbstractPage footerMenuPage (FooterItems item, WebDriver driver) {
        AbstractPage page = null;
        switch (item) {
            case HOME:
                page = new HomePage(driver);
                break;
            case NEWS:
                page = new NewsPage(driver);
                break;
            case REVIEWS:
                page = new ReviewsPage(driver);
                break;
            case COVERAGE:
                page = new CoveargePage(driver);
                break;
            case MERCH_STORE:
                page = new MerchPage(driver);
                break;
            case COMPARE:
                page = new CompareModelsPage(driver);
                break;
            case GLOSSARY:
                page = new GlossaryPage(driver);
                break;
            case FAQ:
                page = new FAQPage(driver);
                break;
            case RSS_FEED:
                page = new RSSFeedPage(driver);
                break;
            case YOUTUBE:
                page = new YoutubePage(driver);
                break;
            case FACEBOOK:
                page = new FacebookPage(driver);
                break;
            case TWITTER:
                page = new TwitterPage(driver);
                break;
            case INSTAGRAM:
                page = new InstagramPage(driver);
                break;
            case GSMARENA:
                page = new GSMArenaPage(driver);
                break;
            case MOBILE_VERSION:
                page = new MobileVersionPage(driver);
                break;
            case ANDROID_APP:
                page = new AndroidAppPage(driver);
                break;
            case TOOLS:
                page = new ToolsPage(driver);
                break;
            case CONTACT_US:
                page = new ContactPage(driver);
                break;
            case PRIVACY:
                page = new PrivacyPage(driver);
                break;
            case TERMS_OF_USE:
                page = new TermsOfUsePage(driver);
                break;
        }
        return page;
    }
}
