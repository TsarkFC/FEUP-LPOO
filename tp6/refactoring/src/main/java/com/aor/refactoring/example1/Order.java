package com.aor.refactoring.example1;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderLine> lines;
    private double totalPrice;

    public Order() {
        lines = new ArrayList<>();
        totalPrice = 0;
    }

    public void add(Product product, int quantity) {
        OrderLine orderLine = new OrderLine(product, quantity);
        lines.add(orderLine);
        totalPrice += orderLine.getPrice();
    }

    public boolean isElegibleForFreeDelivery() {
        return totalPrice > 100;
    }

    public String printOrder() {
        StringBuffer printBuffer = new StringBuffer();

        for (OrderLine line : lines)
            line.printOrderLine(printBuffer);

        printBuffer.append("Total: " + totalPrice);

        return printBuffer.toString();
    }
}