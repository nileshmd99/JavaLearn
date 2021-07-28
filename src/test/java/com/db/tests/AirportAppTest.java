package com.db.tests;

import com.db.airportsapp.Airport;
import com.db.airportsapp.AirportAppFactory;
import com.db.airportsapp.AirportsAppImpl;
import com.db.airportsapp.IAirportsApp;
import org.junit.Test;
import org.mockito.internal.matchers.Null;
import java.nio.file.*;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class AirportAppTest {

    @Test
    public void testFindAirportByCode() {
        IAirportsApp app = AirportAppFactory.getInstance();
        List<Airport> actualAirports = app.findAirportByCode("6523");
        assertFalse(actualAirports.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAirportByCodeBadArgument1() {
        IAirportsApp app = AirportAppFactory.getInstance();
        List<Airport> actualAirports = app.findAirportByCode(null);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testFindAirportByCodeBadFile() {
        IAirportsApp app = AirportAppFactory.getInstance();
    }


    @Test
    public void testFindAirportByName() {
        IAirportsApp app = AirportAppFactory.getInstance();
        List<Airport> actualAirports = app.findAirportByName("Lowell Field");
        assertFalse(actualAirports.isEmpty());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAirportByNameBadArgument1() {
        IAirportsApp app = AirportAppFactory.getInstance();
        List<Airport> actualAirports = app.findAirportByName(null);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testFindAirportByNameBadFile() {
        IAirportsApp app = AirportAppFactory.getInstance();
    }


    @Test
    public void testFindAirportByLatitude() {
        IAirportsApp app = AirportAppFactory.getInstance();
        List<Airport> actualAirports = app.findAirportByLatitude("35.6087");
        assertFalse(actualAirports.isEmpty());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAirportByLatitudeBadArgument1() {
        IAirportsApp app = AirportAppFactory.getInstance();
        List<Airport> actualAirports = app.findAirportByLatitude(null);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testFindAirportByLatitudeBadFile() {
        IAirportsApp app = AirportAppFactory.getInstance();
    }

    @Test
    public void testFindAirportByLongitude() {
        IAirportsApp app = AirportAppFactory.getInstance();
        List<Airport> actualAirports = app.findAirportByLongitude("-116.46");
        assertFalse(actualAirports.isEmpty());

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindAirportByLongitudeBadArgument1() {
        IAirportsApp app = AirportAppFactory.getInstance();
        List<Airport> actualAirports = app.findAirportByLongitude(null);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testFindAirportByLongitudeBadFile() {
        IAirportsApp app = AirportAppFactory.getInstance();
    }

    @Test
    public void testFindAirportRandomly() {
        IAirportsApp app = AirportAppFactory.getInstance();
        Airport Airport1 = app.findAirportRandomly();
        assertFalse(Airport1 == null);
    }

    @Test(expected = java.lang.NullPointerException.class)
    public void testFindAirportRandomlyBadArgument1() {
        IAirportsApp app = AirportAppFactory.getInstance();
        Airport Airport1 = app.findAirportRandomly();

    }
    /*@Test(expected = NoSuchFileException.class)
    public void testFindAirportRandomlyArguments() {
        IAirportsApp app = AirportAppFactory.getInstance();
        Airport Airport1 = app.findAirportRandomly();

    }*/


    @Test
    public void testFindAirportNearMe() {
        IAirportsApp app = AirportAppFactory.getInstance();
        Airport actualAirports = app.findAirportNearMe((double)105.55, (double)-55.33);
    }

    @Test
    public void testFindAirportByAddress() {
        fail("Not Yet Implemented ");
    }

    @Test
    public void testCountTotalAirports() {
        fail("Not Yet Implemented ");
    }

    @Test
    public void testLogin() {
        fail("Not Yet Implemented ");
    }

    @Test
    public void testSignUp() {
        fail("Not Yet Implemented ");
    }

    @Test
    public void testHelp() {
        fail("Not Yet Implemented ");
    }

    @Test
    public void testSiteInfo() {
        fail("Not Yet Implemented ");
    }
}
