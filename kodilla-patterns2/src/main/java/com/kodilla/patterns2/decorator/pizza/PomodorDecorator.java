package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class PomodorDecorator extends AbstractPizzaOrderDecorator {

    public PomodorDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(6.00));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", + pomidory";
    }
}
