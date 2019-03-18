package com.kodilla.good.patterns.challenges.FlightSearchEngine;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightSearcher {

    private List<Connection> connections;

    public FlightSearcher(List<Connection> connections) {
        this.connections = connections;
    }

    public void findConnectionsFromCity(String city){
        connections.stream()
                .filter(e -> city.equals(e.getMainCityForAirportFrom().getCityName()))
                .map(e -> e.getMainCityForAirportTo().getCityName())
                .forEach(System.out::println);
    }

    public void findConnectionsToCity(String city){
        connections.stream()
                .filter(e -> city.equals(e.getMainCityForAirportTo().getCityName()))
                .map(e -> e.getMainCityForAirportFrom().getCityName())
                .forEach(System.out::println);
    }

    public void findConnectionsWithChange(String cityFrom, String cityTo){
        List<Connection> connectionFromList = connections.stream()
                .filter(e -> cityFrom.equals(e.getMainCityForAirportFrom().getCityName()))
                .collect(toList());
        List<Connection> connectionToList = connections.stream()
                .filter(e -> cityTo.equals(e.getMainCityForAirportTo().getCityName()))
                .collect(toList());


        for (Connection elementFrom : connectionFromList) {
            for (Connection elementTo : connectionToList) {

                if (elementFrom.getMainCityForAirportTo().equals(elementTo.getMainCityForAirportFrom())) {
                    System.out.println(cityFrom + " -> " + elementFrom.getMainCityForAirportTo().getCityName() + " -> " + cityTo);
                }
            }
        }

    }
}
