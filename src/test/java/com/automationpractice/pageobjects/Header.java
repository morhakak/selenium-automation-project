package com.automationpractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class Header extends Footer {
    public Header(WebDriver driver) {
        super(driver);
    }

    public static enum topMenu {
        WOMEN,
        DRESSES,
        TSHIRTS
    }

    public static enum womenMenu {
        TSHIRTS,
        BLOUSES,
        CASUAL_DRESSES,
        EVENING_DRESSES,
        SUMMER_DRESSES

    }

    @FindBy(css = ".header_user_info .login")
    private WebElement signIn;
    @FindBy(css = "#contact-link a")
    private WebElement contactUs;
    @FindBy(css = ".shopping_cart  :nth-child(1)")
    private WebElement cart;
    @FindBy(css = ".shop-phone strong")
    private WebElement numOfSite;
    @FindBy(name = "submit_search")
    private WebElement clickOfSearch;
    @FindBy(id = "search_query_top")
    private WebElement searchField;
    @FindBy(css = ".logo.img-responsive")
    private WebElement storeIcon;
    // elements of top nemu
    @FindBy(css = ".sf-menu.clearfix> li> a")
    private List<WebElement> topMenu;

    //     Women's clothing menu

    @FindBy(how = How.CSS, using = "//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li/a")
    private List<WebElement> top_items;
    @FindBy(how = How.CSS, using = "#block_top_menu .submenu-container > li > ul > li > a")
    private List<WebElement> women_items;

    public void clickOnSignIn() {
        click(signIn);
    }

    public void clickOnContactUs() {
        click(contactUs);
    }

    public void clickOnCart() {
        click(cart);
    }

    public String websitePhone() {
        return getText(numOfSite);
    }

    public void productSearch(String text) {
        fillText(searchField, text);
        click(clickOfSearch);
    }

    public void clickOnIconSite() {
        click(storeIcon);
    }

    public void productSelection(topMenu product, womenMenu item) {
        switch (product) {
            case WOMEN:
                hover(topMenu.get(0));
                womenItems(item);
                break;
            case DRESSES:
                click(topMenu.get(1));
                break;
            case TSHIRTS:
                click(topMenu.get(2));
                break;
        }
    }

    public void productSelection(topMenu product) {
        productSelection(product, null);
    }

    private void womenItems(womenMenu item) {
        System.out.println(women_items.size());
        switch (item) {
            case TSHIRTS:
                click(women_items.get(0));
                break;
            case BLOUSES:
                click(women_items.get(1));
                break;
            case CASUAL_DRESSES:
                click(women_items.get(2));
                break;
            case EVENING_DRESSES:
                click(women_items.get(3));
                break;
            case SUMMER_DRESSES:
                click(women_items.get(4));
                break;
        }
    }

}
