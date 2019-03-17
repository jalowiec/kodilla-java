package com.kodilla.good.patterns.challenges.FlightSearchEngine;

import java.util.ArrayList;
import java.util.List;


public class ConnectionsRetriever {

    public List<Connection> retrieve(List<MainCityForAirport> mainCityForAirports){
        List<Connection> connections = new ArrayList<>();

        Connection connectionWaKr = new Connection(mainCityForAirports.get(0), mainCityForAirports.get(1));
        Connection connectionKrWa = new Connection(mainCityForAirports.get(1), mainCityForAirports.get(0));

        Connection connectionWaGd = new Connection(mainCityForAirports.get(0), mainCityForAirports.get(2));
        Connection connectionGdWa = new Connection(mainCityForAirports.get(2), mainCityForAirports.get(0));

        Connection connectionWaKa = new Connection(mainCityForAirports.get(0), mainCityForAirports.get(3));
        Connection connectionKaWa = new Connection(mainCityForAirports.get(3), mainCityForAirports.get(0));

        Connection connectionWaWr = new Connection(mainCityForAirports.get(0), mainCityForAirports.get(4));
        Connection connectionWrWa = new Connection(mainCityForAirports.get(4), mainCityForAirports.get(0));

        Connection connectionWaPo = new Connection(mainCityForAirports.get(0), mainCityForAirports.get(5));
        Connection connectionPoWa = new Connection(mainCityForAirports.get(5), mainCityForAirports.get(0));

        Connection connectionKrGd = new Connection(mainCityForAirports.get(1), mainCityForAirports.get(2));
        Connection connectionGdKr = new Connection(mainCityForAirports.get(2), mainCityForAirports.get(1));

        Connection connectionKrPo = new Connection(mainCityForAirports.get(1), mainCityForAirports.get(5));
        Connection connectionPoKr = new Connection(mainCityForAirports.get(5), mainCityForAirports.get(1));

        Connection connectionKaGd = new Connection(mainCityForAirports.get(3), mainCityForAirports.get(2));
        Connection connectionGdKa = new Connection(mainCityForAirports.get(2), mainCityForAirports.get(3));

        Connection connectionGdPo = new Connection(mainCityForAirports.get(2), mainCityForAirports.get(5));
        Connection connectionPoGd = new Connection(mainCityForAirports.get(5), mainCityForAirports.get(2));

        connections.add(connectionWaKr);
        connections.add(connectionKrWa);
        connections.add(connectionWaGd);
        connections.add(connectionGdWa);
        connections.add(connectionWaKa);
        connections.add(connectionKaWa);
        connections.add(connectionWaWr);
        connections.add(connectionWrWa);
        connections.add(connectionWaPo);
        connections.add(connectionPoWa);
        connections.add(connectionKrGd);
        connections.add(connectionGdKr);
        connections.add(connectionKrPo);
        connections.add(connectionPoKr);
        connections.add(connectionKaGd);
        connections.add(connectionGdKa);
        connections.add(connectionGdPo);
        connections.add(connectionPoGd);


        return  connections;
    }
}

