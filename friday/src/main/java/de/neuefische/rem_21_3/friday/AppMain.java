package de.neuefische.rem_21_3.friday;


import de.neuefische.rem_21_3.friday.model.Order;
import de.neuefische.rem_21_3.friday.model.Product;
import de.neuefische.rem_21_3.friday.service.OrderService;
import de.neuefische.rem_21_3.friday.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AppMain {

    private final ProductService productService = new ProductService();
    private final OrderService orderService = new OrderService();

    public static void main(String[] args) {
        AppMain appMain = new AppMain();

        List<Product> products = appMain.listProducts();
        System.out.println("Current product: " + products);

        Order order = appMain.createOrder(products);
        System.out.println(order + " created");

        Set<Order> orders = appMain.listOrders();
        System.out.println("Current orders: " + orders);

        Optional<Order> orderOpt = appMain.getOrder(0);
        if (orderOpt.isPresent()) {
            Order orderById = orderOpt.get();
            System.out.println("Current order id=" + orderById.getId() + " is :" + orderById);
        }
    }

    public List<Product> listProducts() {
        return productService.listProducts();
    }

    public Order createOrder(List<Product> products) {
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Do not create an order without products");
        }

        Order order = orderService.createNew();
        for (Product product : products) {
            order.add(product);
        }
        return orderService.addOrder(order);
    }

    public Set<Order> listOrders() {
        return orderService.listOrders();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderService.getOrder(id);
    }
}
