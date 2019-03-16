package com.kodilla.good.patterns.challenges.ProductOrder;

import java.time.LocalDateTime;

public class TextOrderRepository implements OrderRepository {
    @Override
    public void createOrder(User user, Product product, LocalDateTime orderDate) {
        System.out.println("Zapisanie informacji o zamowieniu.");
        System.out.println("Zamawiajacy: " + user.getUserId());
        System.out.println("Produkt: " + product.getProductName());
        System.out.println("Data zamowienia: " + orderDate.toString());

    }
}
