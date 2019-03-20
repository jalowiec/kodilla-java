package com.kodilla.spring.calculator;

import com.kodilla.spring.forum.ForumUser;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalculatorTestSuite {

    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring.calculator");
        Calculator calculator = context.getBean(Calculator.class);
        double addResult = calculator.add(3.50, 3.22);
        double subResult = calculator.sub(3.50, 3.22);
        double mulResult = calculator.mul(3.50, 3.22);
        double divResult = calculator.div(3.50, 3.22);

        //Then
        Assert.assertEquals(6.72, addResult, 0.0001);
        Assert.assertEquals(0.28, subResult, 0.0001);
        Assert.assertEquals(11.27, mulResult, 0.0001);
        Assert.assertEquals(1.0869, divResult, 0.0001);

    }
}
