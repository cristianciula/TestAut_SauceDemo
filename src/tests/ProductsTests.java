package tests;

import messages.HeaderMessages;
import messages.ProductsMessages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testdata.Currency;
import testdata.Product;
import testdata.URL;
import utils.ListSorter;

import static org.junit.jupiter.api.Assertions.*;

public class ProductsTests extends BaseTest{

    public static Product product = new Product("product");

    @BeforeEach
    public void beforeEach() {
        super.beforeEach();

        loginPage.authenticate(standardUser);
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        assertTrue(header.shoppingCartButtonIsDisplayed());
        assertTrue(header.menuButtonIsDisplayed());
        assertTrue(productsPage.sortingIsDisplayed());
    }

    @Test
    public void checkProductDetailsInList() {
        assertTrue(productsPage.getAllProductsNames().contains(product.getName()));
        assertTrue(productsPage.productImageIsDisplayed(product.getName()));
        assertEquals(ProductsMessages.PRODUCT_IMAGE, productsPage.getProductImage(product.getName()));
        assertEquals(product.getDescription(), productsPage.getProductDescription(product.getName()));
        assertEquals(Currency.USD + product.getPrice(), productsPage.getProductPrice(product.getName()));
    }

    @Test
    public void addProductToCart() {
        //Add product from Products list to Shopping Cart and check that expected elements have been updated
        productsPage.clickAddToCartButton(product.getName());
        assertEquals("1", header.getCartBadgeValue());
        assertEquals(HeaderMessages.CART_BADGE_COLOR, header.getShoppingCartBadgeColor());
        assertEquals(ProductsMessages.REMOVE_BUTTON, productsPage.getRemoveButtonText(product.getName()));

        //Open Shopping Cart page and check that product is present on page with expected details
        header.clickShoppingCart();
        assertTrue(cartPage.checkoutButtonIsDisplayed());
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));
        assertEquals("1", cartPage.getProductQuantity(product.getName()));
    }

    @Test
    public void removeProductFromCart() {
        //Add product from Products list to Shopping Cart and check that expected elements have been updated on Products page
        productsPage.clickAddToCartButton(product.getName());
        assertEquals("1", header.getCartBadgeValue());
        assertEquals(HeaderMessages.CART_BADGE_COLOR, header.getShoppingCartBadgeColor());
        assertEquals(ProductsMessages.REMOVE_BUTTON, productsPage.getRemoveButtonText(product.getName()));

        //Navigate to Shopping Cart page, check user is on Cart page and check that product is present
        driver.get(URL.CART_PAGE);
        assertTrue(cartPage.checkoutButtonIsDisplayed());
        assertTrue(cartPage.getAllProductsInCart().contains(product.getName()));

        //Navigate back to Products page and check user is on Products page
        driver.get(URL.PRODUCTS_PAGE);
        assertEquals(ProductsMessages.PRODUCTS_PAGE_TITLE, productsPage.getPageTitle());
        assertTrue(productsPage.sortingIsDisplayed());

        //While on Products page, remove product from Shopping Cart and check expected elements have been updated
        productsPage.clickRemoveButton(product.getName());
        assertFalse(header.cartBadgeIsDisplayed());
        assertEquals(ProductsMessages.ADD_TO_CART_BUTTON, productsPage.getAddToCartButtonText(product.getName()));

        //Navigate to Shopping Cart page and check product is no longer present in Cart
        driver.get(URL.CART_PAGE);
        assertTrue(cartPage.checkoutButtonIsDisplayed());
        assertFalse(cartPage.getAllProductsInCart().contains(product.getName()));
    }

    @Test
    public void sortProducts() {
        //Check Products are sorted from A to Z by default
        assertTrue(productsPage.sortNameAZIsSelected());
        assertEquals(ListSorter.sortAZ(productsPage.getAllProductsNames()), productsPage.getAllProductsNames());

        //Sort products by Name from Z to A
        productsPage.sortProductsByNameZToA();
        assertEquals(ListSorter.sortZA(productsPage.getAllProductsNames()), productsPage.getAllProductsNames());

        //Sort products by Price from Low to High
        productsPage.sortProductsByPriceLowToHigh();
        assertEquals(ListSorter.sortLowToHigh(productsPage.getAllProductsPrices()), productsPage.getAllProductsPrices());

        //Sort products by Price from High to Low
        productsPage.sortProductsByPriceHighToLow();
        assertEquals(ListSorter.sortHighToLow(productsPage.getAllProductsPrices()), productsPage.getAllProductsPrices());

        //Sort products by Name from A to Z
        productsPage.sortProductsByNameAToZ();
        assertEquals(ListSorter.sortAZ(productsPage.getAllProductsNames()), productsPage.getAllProductsNames());
    }
}
