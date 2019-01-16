package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("the Forum User");
        String result = simpleUser.getUsername();
        if(result.equals("the Forum User")){
            System.out.println("test OK");
        }
        else{
            System.out.println("ERROR");
        }

        // testy obiektu Calculator:

        Calculator calculator = new Calculator();
        int a = -6;
        int b = 99;

        if(a+b == calculator.add(a, b)){
            System.out.println("Dodawanie OK");
        }
        else{
            System.out.println("Dodawanie ERROR");
        }

        if(a-b == calculator.substract(a, b)){
            System.out.println("Odejmowanie OK");
        }
        else{
            System.out.println("Odejmowanie ERROR");
        }



    }
}