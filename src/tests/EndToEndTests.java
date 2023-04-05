package tests;

import colors.*;
import messages.CartMessages;
import messages.CheckoutInfoMessages;
import messages.CheckoutOverviewMessages;
import messages.ProductsMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Product;
import testdata.UserInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndToEndTests extends BaseTest {

    public static Product product = new Product("product");
    public static UserInfo userInfo = new UserInfo("userInfo");

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();

        loginPage.authenticate(standardUser);
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        assertTrue(header.shoppingCartButtonIsDisplayed());
        assertTrue(header.menuButtonIsDisplayed());
    }

    @Test
    public void buyProduct() {
        //Open Product Details page and check product details
        productsPage.clickProductName(product.getName());
        assertEquals(product.getName(), productDetailsPage.getProductName());
        assertEquals(product.getDescription(), productDetailsPage.getProductDescription());
        assertEquals(product.getPrice(), productDetailsPage.getProductPrice());
        assertTrue(productDetailsPage.productImageIsDisplayed());
        assertEquals(ProductsMessages.PRODUCT_IMAGE, productDetailsPage.getProductImage());

        //Add product to Shopping Cart and check that expected elements on Product Details page have been updated
        productDetailsPage.clickAddToCart();
        assertEquals("1", header.getCartBadgeValue());
        assertEquals(HeaderColors.CART_BADGE_COLOR, header.getShoppingCartBadgeColor());
        assertEquals(ProductsMessages.REMOVE_BUTTON, productDetailsPage.getRemoveButtonText());
        assertEquals(ProductDetailsColors.REMOVE_BUTTON_TEXT_COLOR, productDetailsPage.getRemoveButtonTextColor());

        //Navigate to Shopping Cart and check that product is present in Cart
        header.clickShoppingCart();
        assertEquals(CartMessages.CART_PAGE_TITLE, cartPage.getPageTitle());
        assertTrue(cartPage.checkoutButtonIsEnabled());
        assertEquals(CartColors.CONTINUE_SHOPPING_BUTTON_COLOR, cartPage.getCheckoutButtonColor());
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));
        assertEquals("1", cartPage.getProductQuantity(product.getName()));

        //Continue to Checkout: Your Information page and check page elements
        cartPage.clickCheckoutButton();
        assertEquals(CheckoutInfoMessages.CHECKOUT_INFO_PAGE_TITLE, checkoutInfoPage.getPageTitle());
        assertTrue(checkoutInfoPage.continueButtonIsEnabled());
        assertEquals(CheckoutInfoColors.CONTINUE_BUTTON_COLOR, checkoutInfoPage.getContinueButtonColor());
        assertTrue(checkoutInfoPage.cancelButtonIsEnabled());
        assertEquals(CheckoutInfoMessages.FIRST_NAME_PLACEHOLDER, checkoutInfoPage.getFirstNamePlaceholder());
        assertEquals(CheckoutInfoMessages.LAST_NAME_PLACEHOLDER, checkoutInfoPage.getLastNamePlaceholder());
        assertEquals(CheckoutInfoMessages.ZIP_CODE_PLACEHOLDER, checkoutInfoPage.getZipCodePlaceholder());

        //Fill in the form using valid user data and continue to the next page
        checkoutInfoPage.fillUpForm(userInfo);
        checkoutInfoPage.clickContinue();

        //Check that user is on the Checkout: Overview page, having the expected product and payment details
        assertEquals(CheckoutOverviewMessages.CHECKOUT_OVERVIEW_PAGE_TITLE, checkoutOverviewPage.getPageTitle());
        assertTrue(checkoutOverviewPage.finishButtonIsEnabled());
        assertTrue(checkoutOverviewPage.cancelButtonIsEnabled());
        assertEquals(CheckoutOverviewColors.FINISH_BUTTON_COLOR, checkoutOverviewPage.getFinishButtonColor());
    }
}