package de.neuefische.rem_21_3.friday.model;

import java.util.Set;

public interface Order {

    Integer getId();

    void add(Product product);

    void remove(Product product);

    Set<Product> getProducts();
}
