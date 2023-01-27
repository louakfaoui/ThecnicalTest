package org.louakfaoui.model;

public class RecipeItem {

    private String product;
    private float unitPrice;

    private int quantity;
    private float totalPrice;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTotalPrice() {
        return totalPrice;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void calculateTotalPrice() {
        totalPrice = quantity * unitPrice;
    }
}
