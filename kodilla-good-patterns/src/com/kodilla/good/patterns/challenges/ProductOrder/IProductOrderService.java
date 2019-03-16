package com.kodilla.good.patterns.challenges.ProductOrder;

import java.time.LocalDateTime;

public interface IProductOrderService {
    boolean order(User user, Product product, LocalDateTime orderDate);
}
