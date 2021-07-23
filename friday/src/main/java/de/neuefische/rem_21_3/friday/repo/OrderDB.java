package de.neuefische.rem_21_3.friday.repo;

import de.neuefische.rem_21_3.friday.model.Order;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class OrderDB {

    private final Map<Integer, Order> orders = new HashMap<>();

    public Order add(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order to save must not be null");
        }

        orders.put(order.getId(), order);
        return orders.get(order.getId());
    }

    public Set<Order> list() {
        return new HashSet<>(orders.values());
    }

    public Optional<Order> get(Integer id) {
        if (id == null) {
            return Optional.empty();
        }

        Order order = orders.get(id);
        return Optional.ofNullable(order);
    }

    public Integer nextId() {
        return orders.size();
    }
}
