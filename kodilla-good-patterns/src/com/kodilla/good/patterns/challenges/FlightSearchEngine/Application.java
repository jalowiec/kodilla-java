package com.kodilla.good.patterns.challenges.FlightSearchEngine;

import java.util.List;

public class Application {


    public static void main(String[] args){

        AirportsRetriever airportsRetriever = new AirportsRetriever();
        List<MainCityForAirport> airportList = airportsRetriever.retrieve();
        ConnectionsRetriever connectionsRetriever = new ConnectionsRetriever();
        List<Connection> connectionList = connectionsRetriever.retrieve(airportList);
        FlightSearcher flightSearcher = new FlightSearcher(connectionList);
        System.out.println("Miasta do ktorych mozna leciec z WARSZAWY:");
        flightSearcher.findConnectionsFromCity("WARSZAWA");
        System.out.println("----------------");
        System.out.println("Miasta z ktorych mozna leciec do POZNANIA:");
        flightSearcher.findConnectionsToCity("POZNAN");
        System.out.println("----------------");
        System.out.println("Wyszukiwanie KATOWICE-POZNAN z przesiadkami");
        flightSearcher.findConnectionsWithChange("KATOWICE", "POZNAN");


    }
}
