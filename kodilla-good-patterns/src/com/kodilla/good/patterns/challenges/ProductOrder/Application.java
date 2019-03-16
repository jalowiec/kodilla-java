package com.kodilla.good.patterns.challenges.ProductOrder;

public class Application {

    public static void main(String[] args){
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(
                new TextInformationService(), new ProductOrderService(), new TextOrderRepository());

        productOrderProcessor.process(orderRequest);



    }
}
