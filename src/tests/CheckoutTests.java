package tests;

import colors.HeaderColors;
import colors.ProductDetailsColors;
import messages.ProductsMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTests extends BaseTest {

    public static Product product = new Product("product");

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
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));

    }
}
