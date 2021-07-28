package com.db.airportsapp;

public class AirportAppFactory {

    public static IAirportsApp getInstance() {
        return new AirportsAppImpl();
    }
}
