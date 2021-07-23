package de.neuefische.rem_21_3.friday.service;

import de.neuefische.rem_21_3.friday.model.Order;
import de.neuefische.rem_21_3.friday.model.OrderImpl;
import de.neuefische.rem_21_3.friday.repo.OrderDB;

import java.util.Optional;
import java.util.Set;

public class OrderService {

    private OrderDB orderDB = new OrderDB();

    public Order createNew() {
        return OrderImpl.createEmpty();
    }

    public Order addOrder(Order order) {
        if (order.getId() != null) {
            throw new IllegalArgumentException("An existing order must not be added");
        }

        if (order.getProducts().isEmpty()) {
            throw new IllegalStateException("An order without any products must not been added");
        }

        OrderImpl orderToAdd = OrderImpl.create(orderDB.nextId(), order);

        return orderDB.add(orderToAdd);
    }

    public Set<Order> listOrders() {
        return orderDB.list();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderDB.get(id);
    }
}
