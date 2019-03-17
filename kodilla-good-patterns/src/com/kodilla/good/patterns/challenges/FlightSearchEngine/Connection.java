package com.kodilla.good.patterns.challenges.FlightSearchEngine;

public class Connection {

    private MainCityForAirport mainCityForAirportFrom;
    private MainCityForAirport mainCityForAirportTo;

    public Connection(MainCityForAirport mainCityForAirportFrom, MainCityForAirport mainCityForAirportTo) {
        this.mainCityForAirportFrom = mainCityForAirportFrom;
        this.mainCityForAirportTo = mainCityForAirportTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Connection that = (Connection) o;

        if (mainCityForAirportFrom != null ? !mainCityForAirportFrom.equals(that.mainCityForAirportFrom) : that.mainCityForAirportFrom != null)
            return false;
        return mainCityForAirportTo != null ? mainCityForAirportTo.equals(that.mainCityForAirportTo) : that.mainCityForAirportTo == null;
    }

    @Override
    public int hashCode() {
        int result = mainCityForAirportFrom != null ? mainCityForAirportFrom.hashCode() : 0;
        result = 31 * result + (mainCityForAirportTo != null ? mainCityForAirportTo.hashCode() : 0);
        return result;
    }

    public MainCityForAirport getMainCityForAirportFrom() {
        return mainCityForAirportFrom;
    }

    public MainCityForAirport getMainCityForAirportTo() {
        return mainCityForAirportTo;
    }
}
