package tests;

import messages.ProductsMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsTests extends BaseTest{

    public static Product product = new Product("product");

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();

        loginPage.authenticate(standardUser);
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        assertTrue(header.shoppingCartIsDisplayed());
        assertTrue(productsPage.getAllProductsNames().contains(product.getName()));
    }

    @Test
    public void addItemToCart() throws InterruptedException {
        productsPage.addProductToCart(product.getName());
        Thread.sleep(2000);
    }
}
