package tests;

import colors.HeaderColors;
import messages.ProductsMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Product;

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
    public void addProductToCart() {
        productsPage.addProductToCart(product.getName());
        assertEquals("1", header.getCartBadgeValue());
        assertEquals(HeaderColors.CART_BADGE_COLOR, header.getShoppingCartBadgeColor());
        assertEquals(ProductsMessages.REMOVE_BUTTON, productsPage.getRemoveButtonText(product.getName()));

        header.clickShoppingCart();
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));
    }

    @Test
    public void removeProductFromCart() throws InterruptedException {
        productsPage.addProductToCart(product.getName());
        assertEquals("1", header.getCartBadgeValue());
        assertEquals(ProductsMessages.REMOVE_BUTTON, productsPage.getRemoveButtonText(product.getName()));
        Thread.sleep(1000);

        header.clickShoppingCart();
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));
        Thread.sleep(1000);

        cartPage.clickContinueShopping();
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        Thread.sleep(1000);

        productsPage.removeProductFromCart(product.getName());
        assertFalse(header.cartBadgeIsDisplayed());
        assertEquals(ProductsMessages.ADD_TO_CART_BUTTON, productsPage.getAddToCartButtonText(product.getName()));
        Thread.sleep(2000);

        header.clickShoppingCart();
        Thread.sleep(2000);
        assertFalse(cartPage.productIsPresentInCart(product.getName()));
    }
}
