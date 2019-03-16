package com.kodilla.good.patterns.challenges.ProductOrder;

import java.time.LocalDateTime;

public interface OrderRepository {

    void createOrder(User user, Product product, LocalDateTime orderDate);

}
