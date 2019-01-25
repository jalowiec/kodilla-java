package com.kodilla.stream.world;

import com.kodilla.stream.sand.Europe;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity(){
        //Given
        Country china = new Country("China", new BigDecimal("1394310000"));
        Country indie = new Country("Indie", new BigDecimal("1342570000"));
        Country usa = new Country("Usa", new BigDecimal("328575000"));
        Country indonesia = new Country("Indonesia", new BigDecimal("268074600"));
        Country brazylia = new Country("Brazylia", new BigDecimal("210155000"));
        Country niemcy = new Country("Niemcy", new BigDecimal("82887000"));
        Country francja = new Country("Francja", new BigDecimal("66992000"));

        Continent amerykaPolnocna = new Continent("Ameryka Polnocna");
        amerykaPolnocna.addCountry(usa);

        Continent amerykaPoludniowa = new Continent("Ameryka Poludniowa");
        amerykaPoludniowa.addCountry(brazylia);

        Continent azja = new Continent("Azja");
        azja.addCountry(china);
        azja.addCountry(indie);
        azja.addCountry(indonesia);

        Continent europa = new Continent("Europa");
        europa.addCountry(niemcy);
        europa.addCountry(francja);

        World world = new World("Ziemia");
        world.addContinent(amerykaPolnocna);
        world.addContinent(amerykaPoludniowa);
        world.addContinent(azja);
        world.addContinent(europa);


        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();
        BigDecimal expectedPeopleQuantity = new BigDecimal("3693563600");

        BigDecimal amerykaPolnocnaPeopleQuantity = amerykaPolnocna.getPeopleQuantity();
        BigDecimal expectedAmerykaPolnocnaPeopleQuantity = new BigDecimal("328575000");

        BigDecimal amerykaPoludniowaPeopleQuantity = amerykaPoludniowa.getPeopleQuantity();
        BigDecimal expectedAmerykaPoludniowaPeopleQuantity = new BigDecimal("210155000");

        BigDecimal azjaPeopleQuantity = azja.getPeopleQuantity();
        BigDecimal expectedAzjaPeopleQuantity = new BigDecimal("3004954600");

        BigDecimal europaPeopleQuantity = europa.getPeopleQuantity();
        BigDecimal expectedEuropaPeopleQuantity = new BigDecimal("149879000");

        BigDecimal totalSumPeopleQuantiy = amerykaPolnocnaPeopleQuantity
                .add(amerykaPoludniowaPeopleQuantity)
                .add(azjaPeopleQuantity)
                .add(europaPeopleQuantity);


        //Then
        assertEquals(expectedPeopleQuantity, totalPeopleQuantity);
        assertEquals(expectedAmerykaPolnocnaPeopleQuantity, amerykaPolnocnaPeopleQuantity);
        assertEquals(expectedAmerykaPoludniowaPeopleQuantity, amerykaPoludniowaPeopleQuantity);
        assertEquals(expectedAzjaPeopleQuantity, azjaPeopleQuantity);
        assertEquals(expectedEuropaPeopleQuantity, europaPeopleQuantity);
        assertEquals(expectedPeopleQuantity, totalSumPeopleQuantiy);




    }
}
