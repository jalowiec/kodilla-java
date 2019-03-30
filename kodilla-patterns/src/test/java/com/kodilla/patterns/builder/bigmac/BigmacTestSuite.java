package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBigMacNew() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun(Bun.WITH_SEZAM)
                .burgers(2)
                .sauce("Barbecue")
                .ingredient("Onion")
                .ingredient("Mushrooms")
                .ingredient("Cheese")
                .build();
        System.out.println(bigmac);

        //When
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        Assert.assertEquals(3, howManyIngredients);
        Assert.assertEquals(2, bigmac.getBurgers());
    }

}
