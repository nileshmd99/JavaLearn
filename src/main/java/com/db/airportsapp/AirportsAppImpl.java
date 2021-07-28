package com.db.airportsapp;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AirportsAppImpl implements IAirportsApp {

    private static List<Airport> airports = null;

    public AirportsAppImpl() {
        try {
            airports = Files.readAllLines(Paths.get("d:/airports.csv")).stream().skip(1).map(AirportsAppImpl::stringToAirport).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airport> findAirportByCode(String code) {
        if (code == null || code.length() == 0)
            throw new IllegalArgumentException();
        //TODO Need to implement this when you have the acutal data
        return airports.stream().filter((each) -> each.getCode().equals(code)).collect(Collectors.toList());
    }

    @Override
    public Airport findAirportRandomly () {
        Random r = new Random();
        Airport e = airports.stream().skip(r.nextInt(airports.size())).findFirst().get();
        return e;
    }


    @Override
    public Airport findAirportNearMe(double lat1, double long1) {
        Airport airport = null;
        double minval = 100000000000.0;
        int n = airports.size();
        for(int i = 0; i < airports.size(); i++)
        {
            double lat2 = -1.0, long2 = -1.0;
            int flag = 0;
            try{
                lat2= Double.parseDouble(airports.get(i).getLatitude());
            }
            catch(NumberFormatException e)
            {
                flag = 1;
            }
            try{
                long2 = Double.parseDouble(airports.get(i).getLongitude());
            }
            catch(NumberFormatException e){
                flag = 1;
            }
            if(flag == 0 && distance(lat1, long1, lat2, long2) < minval)
            {
                minval = distance(lat1, long1, lat2, long2);
                airport = airports.get(i);
            }
        }

        return airport;
    }

    @Override
    public List<Airport> findAirportByName(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException();
        //TODO Need to implement this when you have the acutal data
        return airports.stream().filter((each) -> each.getName().equals(name)).collect(Collectors.toList());
    }

    public List<Airport> findAirportByLatitude(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException();
        //TODO Need to implement this when you have the acutal data
        return airports.stream().filter((each) -> each.getLatitude().equals(name)).collect(Collectors.toList());
    }

    public List<Airport> findAirportByLongitude(String name) {
        if (name == null || name.length() == 0)
            throw new IllegalArgumentException();
        //TODO Need to implement this when you have the acutal data
        return airports.stream().filter((each) -> each.getLongitude().equals(name)).collect(Collectors.toList());
    }
    public double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        return (dist);
    }

    public double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    public double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
    public static Airport stringToAirport(String row) {
        String trimmedData = row.replaceAll("\"", "");
        String[] cols = trimmedData.split(",");
        Airport airport = new Airport();
        airport.setCode(cols[0]);
        airport.setName(cols[3]);
        airport.setLatitude(cols[4]);
        airport.setLongitude(cols[5]);
        return airport;
    }
}
