package com.aor.refactoring.example3;

public class Fixed implements Discount{
    private int discount;
    public Fixed(int discount){
        this.discount = discount;
    }

    public double applyDiscount(double price) {
        return discount > price ? 0 : price - discount;
    }
}
