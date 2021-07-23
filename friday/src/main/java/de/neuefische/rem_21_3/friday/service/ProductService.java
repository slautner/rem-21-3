package de.neuefische.rem_21_3.friday.service;

import de.neuefische.rem_21_3.friday.model.ComplexProduct;
import de.neuefische.rem_21_3.friday.model.Product;
import de.neuefische.rem_21_3.friday.model.StandardProduct;
import de.neuefische.rem_21_3.friday.repo.ProductDB;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private ProductDB productDB;

    public ProductService() {
        this.productDB = new ProductDB();
        productDB
                .add(new StandardProduct(5, "standard_product_1"))
                .add(new StandardProduct(10, "standard_product_2"));

        ComplexProduct complexProduct = new ComplexProduct(20, "complex_product_1");
        complexProduct.setAdditionalStuff("some stuff");

        productDB.add(complexProduct);
    }

    public void setProductDB(ProductDB productDB) {
        if (productDB == null) {
            throw new IllegalArgumentException("ProductDB must not be null");
        }
        this.productDB = productDB;
    }

    public List<Product> listProducts() {
        return productDB.list();
    }

    public Optional<Product> getProduct(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        return productDB.get(id);
    }
}
