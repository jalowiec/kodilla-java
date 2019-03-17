package com.kodilla.good.patterns.challenges.Food2Door;

public abstract class ProductDeliverer {

    OrderDispatcher orderDispatcher = new OrderDispatcher();


    public void getOrderInfo() {
        System.out.println("Pobieranie informacji o dostawcy, oraz ilosci i rodzaju produktu");
    }

    public void transferOrderToDispatcher(Order order) {
        System.out.println("Przekazanie zamowienia do dyspozytora");
        orderDispatcher.transferOrder(order);
    }

    abstract void process();

    public void getOrderSummary() {
        System.out.println("Zwrocenie informacji o tym czy udalo sie zrealizowac zamowienie");
    }

    public final void deliver() {
        getOrderInfo();
        transferOrderToDispatcher(new Order());
        process();
        getOrderSummary();
    }


}
