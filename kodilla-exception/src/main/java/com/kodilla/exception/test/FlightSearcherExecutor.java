package com.kodilla.exception.test;

public class FlightSearcherExecutor {

    public static void main(String[] args){

        Flight flight = new Flight("SKP", "KRK" );
        FlightSearcher flightSearcher = new FlightSearcher();


        try {
            boolean isFlightPossible = flightSearcher.findFlight(flight);
            if (isFlightPossible){
                System.out.println("Lot mozliwy");
            }
            else{
                System.out.println("Lot niemozliwy");
            }

        } catch (RouteNotFoundException e) {
            System.out.println(e.getMessage());
        }




    }
}

