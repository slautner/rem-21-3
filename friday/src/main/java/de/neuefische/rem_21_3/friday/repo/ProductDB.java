package de.neuefische.rem_21_3.friday.repo;

import de.neuefische.rem_21_3.friday.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductDB {

    private final Map<Integer, Product> products = new HashMap<>();

    public ProductDB add(Product product) {
        products.put(product.getId(), product);
        return this;
    }

    public List<Product> list() {
        return new ArrayList<>(products.values());
    }

    public Optional<Product> get(Integer id) {
        if (id == null) {
            return Optional.empty();
        }

        Product product = products.get(id);
        return Optional.ofNullable(product);
    }
}
