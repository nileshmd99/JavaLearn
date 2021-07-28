package com.db.airportsapp;

import java.util.List;

public interface IAirportsApp {
    List<Airport> findAirportByCode(String code);

    List<Airport> findAirportByName(String name);
    List<Airport> findAirportByLatitude(String name);
    List<Airport> findAirportByLongitude(String name);
    Airport findAirportNearMe(double lat1, double long1);
    Airport findAirportRandomly();
}
