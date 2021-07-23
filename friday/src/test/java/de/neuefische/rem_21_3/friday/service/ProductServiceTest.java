package de.neuefische.rem_21_3.friday.service;

import de.neuefische.rem_21_3.friday.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProductServiceTest {

    @Test
    public void testPrefilledProducts() {
        // GIVEN
        ProductService productService = new ProductService();

        // WHEN
        List<Product> actualProducts = productService.listProducts();

        // THEN
        assertEquals(3, actualProducts.size());
    }

    @Test
    public void testGetAProduct() {
        // GIVEN
        ProductService productService = new ProductService();
        List<Product> products = productService.listProducts();

        // WHEN
        Product firstProduct = products.iterator().next();
        assertNotNull(firstProduct);

        Optional<Product> actualProductOpt = productService.getProduct(firstProduct.getId());

        // THEN
        assertTrue(actualProductOpt.isPresent());
    }

    @Test
    public void testGetInvalidIdProduct() {
        // GIVEN
        ProductService productService = new ProductService();

        // WHEN
        Optional<Product> actualProductOpt = productService.getProduct(-1);

        // THEN
        assertFalse(actualProductOpt.isPresent());
    }

    @Test
    public void testGetNullIdProduct() {
        // GIVEN
        ProductService productService = new ProductService();

        // WHEN
        Optional<Product> actualProductOpt = productService.getProduct(null);

        // THEN
        assertFalse(actualProductOpt.isPresent());
    }

}
