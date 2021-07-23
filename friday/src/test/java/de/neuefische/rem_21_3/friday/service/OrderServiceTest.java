package de.neuefische.rem_21_3.friday.service;

import de.neuefische.rem_21_3.friday.model.Order;
import de.neuefische.rem_21_3.friday.model.Product;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class OrderServiceTest {

    @Test
    public void testCreateNewOrder() {
        // GIVEN
        OrderService orderService = new OrderService();

        // WHEN
        Order newOrder = orderService.createNew();

        // THEN
        assertNull(newOrder.getId());
    }

    @Test
    public void testAddProductsToOrder() {
        // GIVEN
        OrderService orderService = new OrderService();
        Set<Order> orders = orderService.listOrders();
        assertTrue(orders.isEmpty());

        // WHEN
        Order newOrder = orderService.createNew();

        ProductService productService = new ProductService();
        List<Product> products = productService.listProducts();
        assertFalse(products.isEmpty());

        Product firstProduct = products.iterator().next();
        newOrder.add(firstProduct);

        // THEN
        Order createdOrder = orderService.addOrder(newOrder);
        assertNotNull(createdOrder.getId());

        orders = orderService.listOrders();
        assertFalse(orders.isEmpty());

        Optional<Order> foundOrderOpt = orderService.getOrder(createdOrder.getId());
        assertTrue(foundOrderOpt.isPresent());
        assertEquals(createdOrder, foundOrderOpt.get());
    }

    @Test
    public void testEmptyOrderMustNotBeAdded() {
        // GIVEN
        OrderService orderService = new OrderService();

        // WHEN
        Order newOrder = orderService.createNew();

        // THEN
        try {
            orderService.addOrder(newOrder);
            fail("Order without products must not been added");

        } catch (IllegalStateException e) {
            // expected
        }
    }

    @Test
    public void testPersistedOrderMustNotBeAdded() {
        // GIVEN
        OrderService orderService = new OrderService();

        // WHEN
        Order newOrder = orderService.createNew();

        ProductService productService = new ProductService();
        List<Product> products = productService.listProducts();
        Product firstProduct = products.iterator().next();
        newOrder.add(firstProduct);

        // THEN

        Order persistedOrder = orderService.addOrder(newOrder);
        assertNotNull(persistedOrder.getId());

        try {
            orderService.addOrder(persistedOrder);
            fail("Already persisted order must not been added");

        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void testCreatedOrderMustNotBeenModifiedByAdd() {
        // GIVEN
        OrderService orderService = new OrderService();
        Set<Order> orders = orderService.listOrders();
        assertTrue(orders.isEmpty());

        // WHEN
        Order newOrder = orderService.createNew();

        ProductService productService = new ProductService();
        List<Product> products = productService.listProducts();
        assertFalse(products.isEmpty());

        Product firstProduct = products.iterator().next();
        newOrder.add(firstProduct);

        // THEN
        Order createdOrder = orderService.addOrder(newOrder);
        assertNotNull(createdOrder.getId());

        try {
            createdOrder.add(firstProduct);
            fail("A persisted order must not been modified");

        } catch (IllegalStateException e) {
            // expected
        }
    }

    @Test
    public void testCreatedOrderMustNotBeenModifiedByRemove() {
        // GIVEN
        OrderService orderService = new OrderService();
        Set<Order> orders = orderService.listOrders();
        assertTrue(orders.isEmpty());

        // WHEN
        Order newOrder = orderService.createNew();

        ProductService productService = new ProductService();
        List<Product> products = productService.listProducts();
        assertFalse(products.isEmpty());

        Product firstProduct = products.iterator().next();
        newOrder.add(firstProduct);

        // THEN
        Order createdOrder = orderService.addOrder(newOrder);
        assertNotNull(createdOrder.getId());

        try {
            createdOrder.remove(firstProduct);
            fail("A persisted order must not been modified");

        } catch (IllegalStateException e) {
            // expected
        }
    }
}
