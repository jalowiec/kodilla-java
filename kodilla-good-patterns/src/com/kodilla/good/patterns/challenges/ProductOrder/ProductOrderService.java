package com.kodilla.good.patterns.challenges.ProductOrder;

import java.time.LocalDateTime;

public class ProductOrderService implements  IProductOrderService{

    @Override
    public boolean order(final User user, final Product product, final LocalDateTime orderDate){

        System.out.println("Order: " + product.getProductName() + " by: " + user.getUserId() + " at: " + orderDate.toString());


        return true;
    }

}
