package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args){
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            secondChallenge.probablyIWillThrowException(2.00, 3.00);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("zakonczenie wywolania funcji ktora prawdopodobnie rzuci wyjatek");
        }
    }
}
