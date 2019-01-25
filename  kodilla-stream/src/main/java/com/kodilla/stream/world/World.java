package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class World implements PeopleQuantity{

    private final String worldName;
    private final List<Continent> continentsList = new ArrayList<>();

    public World(final String worldName) {

        this.worldName = worldName;
    }

    public String getWorldName() {

        return worldName;
    }

    public List<Continent> getContinentsList() {

        return continentsList;
    }

    public void addContinent(Continent continent){
        continentsList.add(continent);
    }

    @Override
    public BigDecimal getPeopleQuantity() {
        BigDecimal worldPeopleQuantity = continentsList.stream()
                .flatMap(continent -> continent.getCountriesList().stream())
                .map(PeopleQuantity::getPeopleQuantity)
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return  worldPeopleQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        return worldName.equals(world.worldName);
    }

    @Override
    public int hashCode() {
        return worldName.hashCode();
    }
}
