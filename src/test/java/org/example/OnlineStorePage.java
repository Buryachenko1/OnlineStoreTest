package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.example.BaseTest.driver;


public class OnlineStorePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @FindBy(css = "#cookiebotDialogOkButton")
    private WebElement acceptCookieButton;

    @FindBy(css = "div.product-slide[data-index='1']")
    private WebElement firstItem;

    @FindBy(css = "span.size-name")
    private WebElement sizeName;

    @FindBy(css = "button[data-testid= 'add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(css = "span[data-testid='cart-confirmation-title']")
    private WebElement cartConfirmationTitle;

    @FindBy(css = "h1[data-testid='product-name']")
    private WebElement expectedProductName;

    @FindBy(css = "div[data-testid='cart-confirmation-product-name']")
    private WebElement actualProductName;

    @FindBy(css = "div[data-testid='cart-confirmation-product-size']")
    private WebElement actualProductSize;

    @FindBy(css = "a[data-testid='cart-confirmation-go-to-cart']")
    private WebElement cartConfirmationProductSizeButton;

    @FindBy(css = "div[data-selen='product-count'].fancy-qty-select__QtyButton-z1g0i4-0")
    private WebElement actualProductCountInDropDown;

    @FindBy(css = "p[data-selen='final-price']")
    private WebElement expectedProductPrice;

    @FindBy(css = "p[data-selen='final-price']")
    private WebElement actualProductPrice;

    @FindBy(css = "button[data-selen='order-link']")
    private WebElement orderButtonInBasket;

    @FindBy(css = "div[data-testid='search-header']")
    private WebElement searchHeader;

    /* @FindBy(css = "div.ds-input-field-content")
    private WebElement searchWrapper;

    @FindBy(css = "span.ds-icon.outline-magnify.ds-icon-size__m")
    private WebElement searchMagnify;

    @FindBy(css = "div.ds-color-variant.ds-color-variant__m.Colors-module__colorVariant[style*='background: red']")
    private WebElement itemColor;

    @FindBy(css = "h2.ds-text.ds-text-variant__paragraph.ds-text-size__m")
    private WebElement searchedItemName;
     */
    @FindBy(css = "a[data-dropdown-id='239'] > span.ds-text.ds-text-variant__caption.ds-text-size__xl")

    private WebElement itemVariant;

    @FindBy(css = "button[data-button-index='2']")
    private WebElement itemCategory;

    @FindBy(css = "#categoryProducts > article:nth-child(2)")
    private WebElement searchedItem;

    @FindBy(css = "div[data-testid='cart-confirmation-close']")
    private WebElement cartConfirmationCloseButton;

    @FindBy(css = "li[data-selen='product-count-option'][data-event-key='2']")
    private WebElement expectedPostIncreaseProductCount;

    @FindBy(css = "li[data-selen='product-count-option'][data-event-key='1']")
    private WebElement expectedPostDecreaseProductCount;

    @FindBy(css = "li[data-selen='product-count-option-remove'][data-event-key='remove']")
    private WebElement expectedPostEmptyProductCount;

    @FindBy(css = "#cartRoot > section > h1")
    private WebElement emptyCartMessage;


    public OnlineStorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void acceptCookies() {
        acceptCookieButton.click();
    }

    public boolean checkIfFirstItemIsClickable() {
        return firstItem.isEnabled();
    }

    public void firstItemClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.product-slide[data-index='1']")));
        firstItem.click();
    }


    public void sizeNameClick() {
        sizeName.click();
    }

    public boolean checkIfAddToCartButtonIsClickable() {
        return addToCartButton.isEnabled();
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public boolean checkConfirmationTitleIsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='cart-confirmation-title']")));
        return cartConfirmationTitle.isDisplayed();
    }

    public String getExpectedProductName() {
        return expectedProductName.getText();
    }

    public String getActualProductName() {
        return actualProductName.getText();
    }

    public String getExpectedProductSize() {
        List<WebElement> sizeNameElements = driver.findElements(By.cssSelector("span.size-name"));
        return sizeNameElements.get(0).getText();
    }

    public String getActualProductSize() {
        String actualProductSizeText = actualProductSize.getText();
        return actualProductSizeText.split("—")[1].trim();
    }

    public boolean checkIfCartConfirmationProductSizeButtonIsClickable() {
        return cartConfirmationProductSizeButton.isEnabled();
    }

    public void cartConfirmationSizeButtonClick() {
        cartConfirmationProductSizeButton.click();
    }

    public int expectedProductPrice() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p[data-selen='final-price']")));
        String expectedProductPriceText = expectedProductPrice.getText().replace("CZK", "").trim().replaceAll("[^\\d]", "");
        return Integer.parseInt(expectedProductPriceText);
    }

    public int actualProductPrice() {
        String actualProductPriceText = actualProductPrice.getText().replace("CZK", "").trim().replaceAll("[^\\d]", "");
        return Integer.parseInt(actualProductPriceText);
    }

    public int getActualProductCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-selen='product-count'].fancy-qty-select__QtyButton-z1g0i4-0")));
        String actualProductCountText = actualProductCountInDropDown.getText().trim();
        return Integer.parseInt(actualProductCountText);
    }

    public boolean checkIfButtonInBasketIsClickable() {
        return orderButtonInBasket.isEnabled();
    }

    public void confirmOrderButton() {
        orderButtonInBasket.click();
    }

    /*
        public void findSearchHeader() {
            searchHeader.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement searchWrapper1 = wait.until(ExpectedConditions.elementToBeClickable(By.id(valueOf(searchWrapper))));
            searchWrapper.sendKeys("Red Dress");
            searchMagnify.click();
        }

        public boolean checkItemColor(){
            return itemColor.isDisplayed();
        }
        public String checkSearchedItemName(){
            return searchedItemName.getText();
        }
    */
    public void openItemVariant() {
        itemVariant.click();
    }

    public void openItemCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-button-index='2']")));
        itemCategory.click();
    }

    public void openSearchedItem() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#categoryProducts > article:nth-child(2)")));
        searchedItem.click();
    }

    public void increaseNumberOfItems() {
        actualProductCountInDropDown.click();
        expectedPostIncreaseProductCount.click();
        wait.until(ExpectedConditions.textToBePresentInElement(
                actualProductCountInDropDown, "2"));
    }
    public void decreaseNumberOfItems() {
        actualProductCountInDropDown.click();
        expectedPostDecreaseProductCount.click();
        wait.until(ExpectedConditions.textToBePresentInElement(
                actualProductCountInDropDown, "1"));
    }

    public void emptyShoppingCart() {
        actualProductCountInDropDown.click();
        expectedPostEmptyProductCount.click();
    }
    public boolean checkIfEmptyCartMessageDisplayed(){
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        String actualText = messageElement.getText().trim();
        return true;
    }

    public void closeCartConfirmation(){
        cartConfirmationCloseButton.click();
    }


}

