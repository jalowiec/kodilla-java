package com.kodilla.good.patterns.challenges.FlightSearchEngine;

public class MainCityForAirport {
    private String cityName;
    private String code;
    private String airportName;

    public MainCityForAirport(String cityName, String code, String airportName) {
        this.cityName = cityName;
        this.code = code;
        this.airportName = airportName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainCityForAirport that = (MainCityForAirport) o;

        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;
        return code != null ? code.equals(that.code) : that.code == null;
    }

    @Override
    public int hashCode() {
        int result = cityName != null ? cityName.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    public String getCityName() {
        return cityName;
    }
}
