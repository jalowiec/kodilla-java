package com.kodilla.good.patterns.challenges.Food2Door;

public abstract class ProductDeliverer {

    abstract void process();

    public void getOrderInfo(){
        System.out.println("Pobieranie informacji o dostawcy, oraz ilosci i rodzaju produktu");
    }

    public void getOrderSummary(){
        System.out.println("Zwrocenie informacji o tym czy udalo sie zrealizowac zamowienie");
    }

    public final void deliver(){
        getOrderInfo();
        process();
        getOrderSummary();
    }


}
