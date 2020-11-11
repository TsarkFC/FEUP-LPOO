package com.aor.refactoring.example1;

public class OrderLine {
    private Product product;
    private int quantity;
    private double price;

    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice()*quantity;
    }

    public void printOrderLine(StringBuffer printBuffer){
        product.printProduct(printBuffer);
        printBuffer.append("(x" + quantity + "): " + price + "\n");
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
