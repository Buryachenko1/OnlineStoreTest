package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OnlineStoreTest extends BaseTest {
    private OnlineStorePage OSPage;
    private static final Logger LOGGER = LoggerFactory.getLogger(OnlineStoreTest.class.getName());

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://www.reserved.com/cz/cz/");
        OSPage = new OnlineStorePage(getDriver());
    }

    @Test
    @DisplayName("End-to-End Test: Add item to cart and verify details")
    public void testEndToEndShoppingProcess() {
        LOGGER.info("Starting test: testEndToEndShoppingProcess");

        // Accept cookies
        OSPage.acceptCookies();
        LOGGER.info("Cookies accepted");

        //Open the first item
        boolean isFirstItemClickable = OSPage.checkIfFirstItemIsClickable();
        assertTrue(isFirstItemClickable, "First Item is not clickable");
        OSPage.firstItemClick();
        LOGGER.info("First item clicked");

        // Choose a size
        OSPage.sizeNameClick();
        LOGGER.info("Size name clicked");

        // Add item to cart
        boolean isAddToCartButtonClickable = OSPage.checkIfAddToCartButtonIsClickable();
        assertTrue(isAddToCartButtonClickable, "Button is not clickable");
        OSPage.addToCart();
        LOGGER.info("Item added to cart");

        // Check confirmation message is displayed
        boolean isConfirmationTitleDisplayed = OSPage.checkConfirmationTitleIsDisplayed();
        assertTrue(isConfirmationTitleDisplayed, "Confirmation message is not displayed");
        LOGGER.info("Confirmation title displayed");

        // Verify product name
        String expectedName = OSPage.getExpectedProductName();
        String actualName = OSPage.getActualProductName();
        assertEquals(expectedName, actualName, "The item name in the modal does not match the item name on the page.");
        LOGGER.info("Expected product name: {}", expectedName);
        LOGGER.info("Actual product name: {}", actualName);

        // Verify product size
        String expectedSize = OSPage.getExpectedProductSize();
        String actualSize = OSPage.getActualProductSize();
        assertEquals(expectedSize, actualSize, "The item size name in the modal does not match the item size name on the page.");
        LOGGER.info("Expected product size: {}", expectedSize);
        LOGGER.info("Actual product size: {}", actualSize);

        // Continue to checkout
        boolean ConfirmationSizeButtonIsClickable = OSPage.checkIfCartConfirmationProductSizeButtonIsClickable();
        assertTrue(ConfirmationSizeButtonIsClickable, "Button is not clickable");
        OSPage.cartConfirmationSizeButtonClick();
        LOGGER.info("Confirmation size button clicked");

        // Check count of items in basket
        int expectedProductCount = 1;
        int actualProductCount = OSPage.getActualProductCount();
        assertEquals(expectedProductCount, actualProductCount, "The item count in the basket does not match the expected item count.");
        LOGGER.info("Expected product count: {}", expectedProductCount);
        LOGGER.info("Actual product count: {}", actualProductCount);

        // Verify product price
        int expectedProductPrice = OSPage.expectedProductPrice();
        int actualProductPrice = OSPage.actualProductPrice();
        assertEquals(expectedProductPrice, actualProductPrice, "The item price in the basket does not match the expected item price.");
        LOGGER.info("Expected product price: {}", expectedProductPrice);
        LOGGER.info("Actual product price: {}", actualProductPrice);

        // Confirm order
        boolean isOrderButtonClickable = OSPage.checkIfButtonInBasketIsClickable();
        assertTrue(isOrderButtonClickable, "Button in basket is not clickable");
        OSPage.confirmOrderButton();
        LOGGER.info("Confirmation order button clicked");
    }
    @Test
    @DisplayName("Searching an item and adding to the shopping cart")
    public void testSearchAndAddItemToCart() {
        LOGGER.info("Starting test: testSearchAndAddItemToCart");

        // Accept cookies
        OSPage.acceptCookies();
        LOGGER.info("Cookies accepted");

        /*Search an item - step is not working because of switched off autocomplete

        OSPage.findSearchHeader(); //step is not working because of switched off autocomplete
        LOGGER.info("Search results displayed");

        //check Items color in search result
        boolean itemsColorIsCorrect = OSPage.checkItemColor();
        assertTrue(itemsColorIsCorrect,"Items color doesn't match the color input in the search field");
        LOGGER.info("Items color matches the color input in the search field");

        //Check if the item name in search result includes "DRESS"
        String displayedItemsNameIncludesSearchedItem = OSPage.checkSearchedItemName();
        assertTrue(displayedItemsNameIncludesSearchedItem.contains("DRESS"), "The item name does not include 'DRESS'");
        LOGGER.info("Displayed item's name includes searched word: {}", displayedItemsNameIncludesSearchedItem.contains("DRESS"));
        */

        //Open category and choose item category - used instead of searching of item
        OSPage.openItemVariant();
        OSPage.openItemCategory();
        OSPage.openSearchedItem();
        LOGGER.info("Search item opened");

        // Choose a size
        OSPage.sizeNameClick();
        LOGGER.info("Size name clicked");

        // Add item to cart
        boolean isAddToCartButtonClickable = OSPage.checkIfAddToCartButtonIsClickable();
        assertTrue(isAddToCartButtonClickable, "Button is not clickable");
        OSPage.addToCart();
        LOGGER.info("Item added to cart");


        // Check confirmation message is displayed
        boolean isConfirmationTitleDisplayed = OSPage.checkConfirmationTitleIsDisplayed();
        assertTrue(isConfirmationTitleDisplayed, "Confirmation message is not displayed");
        LOGGER.info("Confirmation title displayed");

        // Verify product name
        String expectedName = OSPage.getExpectedProductName();
        String actualName = OSPage.getActualProductName();
        assertEquals(expectedName, actualName, "The item name in the modal does not match the item name on the page.");
        LOGGER.info("Expected product name: {}", expectedName);
        LOGGER.info("Actual product name: {}", actualName);

        // Verify product size
        String expectedSize = OSPage.getExpectedProductSize();
        String actualSize = OSPage.getActualProductSize();
        assertEquals(expectedSize, actualSize, "The item size name in the modal does not match the item size name on the page.");
        LOGGER.info("Expected product size: {}", expectedSize);
        LOGGER.info("Actual product size: {}", actualSize);
    }
    @Test
    @DisplayName("Increase number of items at the shopping cart")
    public void testIncreaseNumberOfItemsAtCart() {
        LOGGER.info("Starting test: testIncreaseNumberOfItemsAtCart");

        // Accept cookies
        OSPage.acceptCookies();
        LOGGER.info("Cookies accepted");

        //Open the first item
        boolean isFirstItemClickable = OSPage.checkIfFirstItemIsClickable();
        assertTrue(isFirstItemClickable, "First Item is not clickable");
        OSPage.firstItemClick();
        LOGGER.info("First item clicked");

        // Choose a size
        OSPage.sizeNameClick();
        LOGGER.info("Size name clicked");

        // Add item to cart
        boolean isAddToCartButtonClickable = OSPage.checkIfAddToCartButtonIsClickable();
        assertTrue(isAddToCartButtonClickable, "Button is not clickable");
        OSPage.addToCart();
        LOGGER.info("Item added to cart");

        // Continue to checkout
        boolean ConfirmationSizeButtonIsClickable = OSPage.checkIfCartConfirmationProductSizeButtonIsClickable();
        assertTrue(ConfirmationSizeButtonIsClickable, "Button is not clickable");
        OSPage.cartConfirmationSizeButtonClick();
        LOGGER.info("Confirmation size button clicked");

        //Increase number of items
        OSPage.increaseNumberOfItems();
        LOGGER.info("Item count increased");

        // Check count of items in basket
        int expectedProductCount = 2;
        int actualProductCount = OSPage.getActualProductCount();
        assertEquals(expectedProductCount, actualProductCount, "The item count in the basket does not match the expected item count.");
        LOGGER.info("Expected product count: {}", expectedProductCount);
        LOGGER.info("Actual product count: {}", actualProductCount);
    }

    @Test
    @DisplayName("Empty shopping cart by quantity reducing")
    public void testEmptyShoppingCart() {
        LOGGER.info("Starting test: testEmptyShoppingCart");

        // Accept cookies
        OSPage.acceptCookies();
        LOGGER.info("Cookies accepted");

        //Open the first item
        boolean isFirstItemClickable = OSPage.checkIfFirstItemIsClickable();
        assertTrue(isFirstItemClickable, "First Item is not clickable");
        OSPage.firstItemClick();
        LOGGER.info("First item clicked");

        // Choose a size
        OSPage.sizeNameClick();
        LOGGER.info("Size name clicked");

        // Add item to cart
        boolean isAddToCartButtonClickable = OSPage.checkIfAddToCartButtonIsClickable();
        assertTrue(isAddToCartButtonClickable, "Button is not clickable");
        OSPage.addToCart();
        LOGGER.info("Item added to cart");

        // Continue to checkout
        boolean ConfirmationSizeButtonIsClickable = OSPage.checkIfCartConfirmationProductSizeButtonIsClickable();
        assertTrue(ConfirmationSizeButtonIsClickable, "Button is not clickable");
        OSPage.cartConfirmationSizeButtonClick();
        LOGGER.info("Confirmation size button clicked");

        // Empty cart
        OSPage.emptyShoppingCart();

        //Check if the cart is empty
        boolean isMessageDisplayed = OSPage.checkIfEmptyCartMessageDisplayed();
        assertTrue(isMessageDisplayed, "The empty cart message was not displayed as expected.");
        LOGGER.info("Empty cart message is displayed as expected.");
    }

}
