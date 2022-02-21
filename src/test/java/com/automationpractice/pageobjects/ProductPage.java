package com.automationpractice.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(css = "[name='Submit']")
    private WebElement addToCartBtn;
    @FindBy(css = "[title='Proceed to checkout']")
    private WebElement proceedToCheckoutBtn;
    @FindBy(css = "[title='Continue shopping']")
    private WebElement continueShoppingBtn;
    @FindBy(css = ".layer_cart_product  h2")
    private WebElement addToCartSuccessMsg;
    @FindBy(css = "[title='Close window']")
    private WebElement closeAddToCartPopUp;
    @FindBy(css = ".product_quantity_up")
    private WebElement addQtyBtn;
    @FindBy(css = "product_quantity_down")
    private WebElement qtyReductionBtn;
    @FindBy(css = "#group_1")
    private WebElement sizesDropDown;
    @FindBy(css = "#group_1 option")
    private List<WebElement> sizeOptionsList;
    @FindBy(css = "#group_1")
    private List<WebElement> colors;
    @FindBy(css = "#layer_cart_product_attributes")
    private WebElement selectedAttributes;
    @FindBy(css = "#layer_cart_product_quantity")
    private WebElement selectedQty;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnAddToCartBtn() {
        click(addToCartBtn);
    }

    public ProductPage clickOnAddQtyBtn() {
        click(addQtyBtn);
        return this;
    }

    public ProductPage clickOnReductionQtyBtn() {
        click(qtyReductionBtn);
        return this;
    }

    public ProductPage setQuantity(String quantity) {
        int intQuantity = Integer.parseInt(quantity) - 1;
        for (int i = 0; i < intQuantity; i++) {
            clickOnAddQtyBtn();
        }
        return this;
    }

    public ProductPage setQuantity(int quantity) {
        for (int i = 0; i < quantity - 1; i++) {
            clickOnAddQtyBtn();
        }
        return this;
    }

    public ProductPage chooseSize(String size) {
        selectByText(sizesDropDown, size);
        return this;
    }

    public ProductPage chooseColor(String color) {
        for (WebElement colorOption : colors) {
            if (colorOption.getAttribute("name").equalsIgnoreCase(color))
                click(colorOption);
        }
        return this;
    }

    public void addToCart(String quantity, String size, String color) {
        setQuantity(quantity);
        chooseSize(size);
        chooseColor(color);
        clickOnAddToCartBtn();
    }

    private boolean isSizeSelected(String size) {
        wait.until(ExpectedConditions.visibilityOf(selectedAttributes));
        if (getText(selectedAttributes).contains(size)) {
            return true;
        }
        return false;
    }

    private boolean isColorSelected(String color) {
        wait.until(ExpectedConditions.visibilityOf(selectedAttributes));
        if (getText(selectedAttributes).toLowerCase().contains(color)) {
            return true;
        }
        return false;
    }

    private boolean isQuantitySelected(String quantity) {
        wait.until(ExpectedConditions.visibilityOf(selectedQty));
        if (getText(selectedQty).contains(quantity)){
            return true;
        }
        return false;
    }

    private boolean isSuccessMsgDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(addToCartSuccessMsg));
        if (addToCartSuccessMsg.isDisplayed())
            return true;
        return false;
    }

    public boolean isAddedToCartSuccessfully(String color, String size, String quantity) {
        if (isColorSelected(color) && isSizeSelected(size) && isSuccessMsgDisplayed() &&
            isQuantitySelected(quantity))
            return true;
        return false;
    }
}

