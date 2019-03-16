package com.kodilla.good.patterns.challenges.ProductOrder;

public class TextInformationService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("Potwierdzenie zamówienia dla: " + user.getUserName() + " " + user.getUserSurname());
    }
}
