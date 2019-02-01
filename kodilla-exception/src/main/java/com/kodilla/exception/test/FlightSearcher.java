package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearcher {

    public void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> arrivalAirport = new HashMap<>();
        arrivalAirport.put("FRA", true);
        arrivalAirport.put("KRK", true);
        arrivalAirport.put("LGW", false);
        arrivalAirport.put("RMI", true);
        arrivalAirport.put("WAW", false);

        if(!arrivalAirport.containsKey(flight.arrivalAirport)){
            throw  new RouteNotFoundException("Nie znaleziono lotniska w bazie lotnisk.");
        }


    }


}
