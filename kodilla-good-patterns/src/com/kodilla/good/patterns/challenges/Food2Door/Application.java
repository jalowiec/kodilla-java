package com.kodilla.good.patterns.challenges.Food2Door;

public class Application {
    public static void main(String[] args){
        ExtraFoodShopDeliverer extraFoodShopDeliverer = new ExtraFoodShopDeliverer();
        HealthyShop healthyShop = new HealthyShop();
        extraFoodShopDeliverer.deliver();
        System.out.println();
        healthyShop.deliver();
    }
}
