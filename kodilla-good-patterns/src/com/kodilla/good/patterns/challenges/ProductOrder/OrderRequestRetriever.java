package com.kodilla.good.patterns.challenges.ProductOrder;

import java.time.LocalDateTime;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("Jan", "Kowalski", 123);
        Product product = new Product("Eurobusiness", "Wspaniala ekonomiczna gra planszowa", 31.99);
        return new OrderRequest(user, product, LocalDateTime.now());
    }
}
