package com.kodilla.exception.test;

public class FlightSearcherExecutor {

    public static void main(String[] args){

        Flight flight = new Flight("SKP", "SPU" );
        FlightSearcher flightSearcher = new FlightSearcher();
        try {
            flightSearcher.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }
}

