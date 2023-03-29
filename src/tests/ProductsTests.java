package tests;

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
        assertEquals("1", header.getCartCounterValue());
    }

    @Test
    public void removeProductFromCart() {
        productsPage.addProductToCart(product.getName());
        assertEquals("1", header.getCartCounterValue());

        productsPage.removeProductFromCart(product.getName());
        assertFalse(header.cartCounterIsDisplayed());
    }
}
