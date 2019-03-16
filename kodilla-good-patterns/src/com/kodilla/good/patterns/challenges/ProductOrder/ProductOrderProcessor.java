package com.kodilla.good.patterns.challenges.ProductOrder;

public class ProductOrderProcessor {
    private InformationService informationService;
    private IProductOrderService iProductOrderService;
    private OrderRepository orderRepository;

    public ProductOrderProcessor(InformationService informationService, IProductOrderService iProductOrderService, OrderRepository orderRepository) {
        this.informationService = informationService;
        this.iProductOrderService = iProductOrderService;
        this.orderRepository = orderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest){
        boolean isOrdered = iProductOrderService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderDate());
        if(isOrdered){
            informationService.inform(orderRequest.getUser());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getOrderDate());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), true);
        }else
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), false);
    }
}
