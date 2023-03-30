package tests;

import colors.HeaderColors;
import messages.ProductsMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Product;
import testdata.URL;

import static org.junit.jupiter.api.Assertions.*;

public class ProductsTests extends BaseTest{

    public static Product product = new Product("product");

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();

        loginPage.authenticate(standardUser);
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        assertTrue(header.shoppingCartButtonIsDisplayed());
        assertTrue(productsPage.getAllProductsNames().contains(product.getName()));
    }

    @Test
    public void checkProductDetails() {
        assertTrue(productsPage.productImageIsDisplayed(product.getName()));
        assertEquals(ProductsMessages.PRODUCT_IMAGE, productsPage.getProductImage(product.getName()));
    }

    @Test
    public void addProductToCart() {
        productsPage.clickAddToCartButton(product.getName());
        assertEquals("1", header.getCartBadgeValue());
        assertEquals(HeaderColors.CART_BADGE_COLOR, header.getShoppingCartBadgeColor());
        assertEquals(ProductsMessages.REMOVE_BUTTON, productsPage.getRemoveButtonText(product.getName()));

        header.clickShoppingCart();
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));
    }

    @Test
    public void removeProductFromCart() throws InterruptedException {
        productsPage.clickAddToCartButton(product.getName());
        assertEquals("1", header.getCartBadgeValue());
        assertEquals(HeaderColors.CART_BADGE_COLOR, header.getShoppingCartBadgeColor());
        assertEquals(ProductsMessages.REMOVE_BUTTON, productsPage.getRemoveButtonText(product.getName()));

        driver.get(URL.CART_PAGE);
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));

        driver.get(URL.PRODUCTS_PAGE);
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());

        productsPage.clickRemoveButton(product.getName());
        assertFalse(header.cartBadgeIsDisplayed());
        assertEquals(ProductsMessages.ADD_TO_CART_BUTTON, productsPage.getAddToCartButtonText(product.getName()));

        driver.get(URL.CART_PAGE);
        assertFalse(cartPage.productIsPresentInCart(product.getName()));
    }
}
