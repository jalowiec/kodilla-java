package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Aspect
public class ProcessOrderWatcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(com.kodilla.patterns2.aop.calculator.Watcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" + "&& args(order, userId)")
    public void logEvent(OrderDto order, Long userId){
        LOGGER.info("Wywolanie metody processOrder. Args: " + order.getClass().getName() + " " + userId);
    }
}
