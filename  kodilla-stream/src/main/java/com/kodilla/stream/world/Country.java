package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country implements PeopleQuantity {

    private final String countryName;
    private final BigDecimal peopleQuantity;

    public Country(final String countryName, final BigDecimal peopleQuantity) {
        this.countryName = countryName;
        this.peopleQuantity = peopleQuantity;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public BigDecimal getPeopleQuantity() {
        return this.peopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        return countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {
        int result = countryName.hashCode();
        result = 31 * result + peopleQuantity.hashCode();
        return result;
    }
}
