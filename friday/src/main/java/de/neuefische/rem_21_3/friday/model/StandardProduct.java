package de.neuefische.rem_21_3.friday.model;

public class StandardProduct extends BaseProduct implements Product {

    public StandardProduct(Integer id, String name) {
        super(name);
        setId(id);
    }
}
