package com.automationpractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends Header {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // enum from product titles
    public static enum namProductTitles {
        SAILE,
        SUMMER,
        TOP_TRENDS,
        MENS,
        WOMENS,
        SUNGLASSES,
        SAVVY_TRENDS
    }

    // enum - Sort by bestseller or popular
    public static enum typesOfSorting {
        POPULAR,
        BESTSELLER,
    }

    @FindBy(className = "bx-viewport")
    private WebElement homeSlider;
    @FindBy(className = "col-xs-4")
    private List<WebElement> productTitles;
    @FindBy(css = "#home-page-tabs > li > a")
    private List<WebElement> displayBySort;
    @FindBy(css = ".right-block> [itemprop='name']>a")
    private List<WebElement> homeItemsName;
    @FindBy(className = "ajax_add_to_cart_button")
    private List<WebElement> addToCart;
    @FindBy(css = ".cross[title='Close window']")
    private WebElement exitPopupAddToCart;
    @FindBy(css = ".shopping_cart> a")
    private WebElement hoveringOnTheCart;
    @FindBy(css = ".price.cart_block_total.ajax_block_cart_total")
    private WebElement updatedPriceOnTheCartTotal;


    @FindBy(css = ".button-container .button.lnk_view.btn.btn-default")
    List<WebElement> mor;
    @FindBy(css = ".product-image-container .price.product-price")
    //.product-image-container  .price.product-price
    //.right-block .price.product-price
    List<WebElement> productPrices;


    public void clickOnHomeSlider() {
        click(homeSlider);
    }

    public void clickOnProductTitle(namProductTitles namTitle) {
        switch (namTitle) {
            case SAILE:
                click(productTitles.get(0));
                break;
            case SUMMER:
                click(productTitles.get(1));
                break;
            case TOP_TRENDS:
                click(productTitles.get(2));
                break;
            case MENS:
                click(productTitles.get(3));
                break;
            case WOMENS:
                click(productTitles.get(4));
                break;
            case SUNGLASSES:
                click(productTitles.get(5));
                break;
            case SAVVY_TRENDS:
                click(productTitles.get(6));
        }

    }


    public void clickOnHomeItemsNameByPrice(double price) {
        for (int i = 0; i <= productPrices.size(); i++) {
            hover(homeItemsName.get(i));
            String replacePrice = productPrices.get(i).getText().replace("$", "");
            if (Double.parseDouble(replacePrice) == price) {
                click(homeItemsName.get(i));
                break;
            }
        }
    }

    public void clickOnAddToCartByPrice(double price) {
        for (int i = 0; i <= productPrices.size(); i++) {
            hover(homeItemsName.get(i));
            String replacePrice = productPrices.get(i).getText().replace("$", "");
            if (Double.parseDouble(replacePrice) == price) {
                click(addToCart.get(i));
                click(exitPopupAddToCart);
                break;
            }
        }
    }

    public void SortByBestsellerOrPopular(typesOfSorting sortType) {
        switch (sortType) {
            case POPULAR:
                click(displayBySort.get(0));
                break;
            case BESTSELLER:
                click(displayBySort.get(1));
                break;
        }
    }

    public void clickOnMorByPrice(double price) {
        for (int i = 0; i <= productPrices.size(); i++) {
            hover(homeItemsName.get(i));
            String replacePrice = productPrices.get(i).getText().replace("$", "");
            if (Double.parseDouble(replacePrice) == price) {
                click(mor.get(i));
                break;
            }
        }
    }

    // validation method

    public double validTotalPriceInCart() {
        hover(hoveringOnTheCart);
        double totalPrice = Double.parseDouble(updatedPriceOnTheCartTotal.getText().replace("$", ""));
        return totalPrice;
    }

}
