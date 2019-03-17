package com.kodilla.good.patterns.challenges.FlightSearchEngine;

import java.util.ArrayList;
import java.util.List;

public class AirportsRetriever {

    public List<MainCityForAirport> retrieve(){
        List<MainCityForAirport> mainCityForAirports = new ArrayList<>();
        MainCityForAirport warszawa = new MainCityForAirport("WARSZAWA", "WAW", "Lotnisko Chopina w Warszawie");
        MainCityForAirport krakow = new MainCityForAirport("KRAKOW", "KRK", "Port lotniczy Kraków-Balice im. Jana Pawła II");
        MainCityForAirport gdansk = new MainCityForAirport("GDANSK", "GDN", "Port lotniczy Gdańsk-Rębiechowo im. Lecha Wałęsy");
        MainCityForAirport katowice = new MainCityForAirport("KATOWICE", "KTW", " Międzynarodowy Port Lotniczy Katowice w Pyrzowicach");
        MainCityForAirport wroclaw = new MainCityForAirport("WROCLAW", "WRO", "Port lotniczy Wrocław-Strachowice im. Mikołaja Kopernika");
        MainCityForAirport poznan = new MainCityForAirport("POZNAN", "POZ", " Port lotniczy Poznań-Ławica im. Henryka Wieniawskiego");

        mainCityForAirports.add(warszawa);
        mainCityForAirports.add(krakow);
        mainCityForAirports.add(gdansk);
        mainCityForAirports.add(katowice);
        mainCityForAirports.add(wroclaw);
        mainCityForAirports.add(poznan);

        return mainCityForAirports;
    }
}
