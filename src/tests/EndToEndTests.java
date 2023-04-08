package tests;

import messages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Product;
import testdata.UserData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EndToEndTests extends BaseTest {

    public static Product product = new Product("product");
    public static UserData userData = new UserData("userData");

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();

        loginPage.authenticate(standardUser);
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        assertTrue(header.shoppingCartButtonIsDisplayed());
        assertTrue(header.menuButtonIsDisplayed());
        assertTrue(productsPage.sortingIsDisplayed());

        //Check expected product is present on the Products page with expected details
        assertTrue(productsPage.getAllProductsNames().contains(product.getName()));
        assertEquals(ProductsMessages.PRODUCT_IMAGE, productsPage.getProductImage(product.getName()));
        assertEquals(product.getDescription(), productsPage.getProductDescription(product.getName()));
        assertEquals(product.getPrice(), productsPage.getProductPrice(product.getName()));
    }

    @Test
    public void buyProduct() {
        //Open Product Details page of a selected product and check the product's details
        productsPage.clickProductName(product.getName());
        assertEquals(product.getName(), productDetailsPage.getProductName());
        assertEquals(product.getDescription(), productDetailsPage.getProductDescription());
        assertEquals(product.getPrice(), productDetailsPage.getProductPrice());
        assertEquals(ProductsMessages.PRODUCT_IMAGE, productDetailsPage.getProductImage());

        //Add product to Shopping Cart and check that expected elements on Product Details page have been updated
        productDetailsPage.clickAddToCart();
        assertEquals("1", header.getCartBadgeValue());
        assertEquals(HeaderMessages.CART_BADGE_COLOR, header.getShoppingCartBadgeColor());
        assertEquals(ProductsMessages.REMOVE_BUTTON, productDetailsPage.getRemoveButtonText());
        assertEquals(ProductDetailsMessages.REMOVE_BUTTON_TEXT_COLOR, productDetailsPage.getRemoveButtonTextColor());

        //Navigate to Shopping Cart and check that product is present in Cart
        header.clickShoppingCart();
        assertEquals(CartMessages.CART_PAGE_TITLE, cartPage.getPageTitle());
        assertTrue(cartPage.checkoutButtonIsEnabled());
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));
        assertEquals("1", cartPage.getProductQuantity(product.getName()));

        //Continue to Checkout: Your Information page and check user is on the expected page
        cartPage.clickCheckoutButton();
        assertEquals(CheckoutInfoMessages.CHECKOUT_INFO_PAGE_TITLE, checkoutInfoPage.getPageTitle());
        assertTrue(checkoutInfoPage.firstNameInputIsDisplayed());
        assertTrue(checkoutInfoPage.lastNameInputIsDisplayed());
        assertTrue(checkoutInfoPage.zipCodeInputIsDisplayed());
        assertTrue(checkoutInfoPage.continueButtonIsEnabled());

        //Fill in the form using valid user data, continue to Checkout Overview page and verify user is on expected page
        checkoutInfoPage.fillUpForm(userData);
        checkoutInfoPage.clickContinue();
        assertEquals(CheckoutOverviewMessages.CHECKOUT_OVERVIEW_PAGE_TITLE, checkoutOverviewPage.getPageTitle());
        assertTrue(checkoutOverviewPage.finishButtonIsEnabled());
        assertTrue(checkoutOverviewPage.totalLabelIsDisplayed());

        //Check that all details on the Checkout Overview page are accurate
        assertEquals(userData.getCreditCard(), checkoutOverviewPage.getCardInformation());
        assertEquals(userData.getShippingInfo(), checkoutOverviewPage.getShippingInformation());
        assertEquals(product.getPrice(), checkoutOverviewPage.getItemTotalValue());

        checkoutOverviewPage.getTotalValue();
    }
}
