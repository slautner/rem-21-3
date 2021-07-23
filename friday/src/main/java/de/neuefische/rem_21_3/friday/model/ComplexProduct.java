package de.neuefische.rem_21_3.friday.model;

public class ComplexProduct extends BaseProduct implements Product {

    private String additionalStuff;

    public ComplexProduct(Integer id, String name) {
        super(name);
        setId(id);
    }

    public String getAdditionalStuff() {
        return additionalStuff;
    }

    public void setAdditionalStuff(String additionalStuff) {
        this.additionalStuff = additionalStuff;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + getId() + ", name=" + getName() + ", addStuff" + additionalStuff + "]";
    }
}
