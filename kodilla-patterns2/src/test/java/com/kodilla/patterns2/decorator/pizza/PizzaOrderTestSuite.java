package com.kodilla.patterns2.decorator.pizza;


import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(15.00), calculatedCost);

    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza (ciasto, sos pomidorowy, ser)", description);

    }

    @Test
    public void testCornPepperPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CornDecorator(theOrder);
        theOrder = new PepperDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(19.50), calculatedCost);

    }

    @Test
    public void testCornPepperOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new CornDecorator(theOrder);
        theOrder = new PepperDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza (ciasto, sos pomidorowy, ser), + kukurydza, + papryka", description);

    }

    @Test
    public void testDoublePomodorPizzaOrderGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PomodorDecorator(theOrder);
        theOrder = new PomodorDecorator(theOrder);
        //When
        BigDecimal calculatedCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(27.00), calculatedCost);

    }

    @Test
    public void testDoublePomodorOrderGetDescription() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new PomodorDecorator(theOrder);
        theOrder = new PomodorDecorator(theOrder);
        //When
        String description = theOrder.getDescription();
        //Then
        assertEquals("Pizza (ciasto, sos pomidorowy, ser), + pomidory, + pomidory", description);

    }

}
