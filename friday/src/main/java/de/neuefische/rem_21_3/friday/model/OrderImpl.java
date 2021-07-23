package de.neuefische.rem_21_3.friday.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class OrderImpl implements Order {

    private final Set<Product> products = new HashSet<>();
    private final Integer id;

    private OrderImpl(Integer id) {
        this.id = id;
    }

    public static OrderImpl createEmpty() {
        return new OrderImpl(null);
    }

    public static OrderImpl create(Integer id, Order order) {
        OrderImpl orderImpl = new OrderImpl(id);
        orderImpl.products.addAll(order.getProducts());
        return orderImpl;
    }

    public Integer getId() {
        return id;
    }

    public void add(Product product) {
        checkOrderAlreadyPersisted();
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null to be added to an order");
        }
        this.products.add(product);
    }

    private void checkOrderAlreadyPersisted() {
        if (id != null) {
            throw new IllegalStateException("A persisted order must not been modified");
        }
    }

    public void remove(Product product) {
        checkOrderAlreadyPersisted();
        if (product != null) {
            this.products.remove(product);
        }
    }

    public Set<Product> getProducts() {
        // any add or remove operation on the products is not allowed
        return Collections.unmodifiableSet(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderImpl order = (OrderImpl) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "[id=" + id + ", products={" + products + "}";
    }
}
