package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Continent implements PeopleQuantity{

    private final String continentName;
    private final List<Country> countriesList = new ArrayList<>();

    public Continent(final String continentName) {
        this.continentName = continentName;
    }

    public String getContinentName() {
        return continentName;
    }

    public List<Country> getCountriesList() {
        return countriesList;
    }

    public void addCountry(Country country){
        countriesList.add(country);
    }

    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal continentPeopleQuantity = countriesList.stream()
                .map(PeopleQuantity::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return continentPeopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Continent continent = (Continent) o;

        return continentName.equals(continent.continentName);
    }

    @Override
    public int hashCode() {
        return continentName.hashCode();
    }
}
