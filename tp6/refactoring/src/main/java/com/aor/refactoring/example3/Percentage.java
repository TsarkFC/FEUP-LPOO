package com.aor.refactoring.example3;

public class Percentage implements Discount{
    private double discount;
    public Percentage(double discount){
        this.discount = discount;
    }

    public double applyDiscount(double price) {
        return price - price * discount;
    }
}
