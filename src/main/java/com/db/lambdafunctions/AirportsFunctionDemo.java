package com.db.lambdafunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AirportsFunctionDemo {
    public static void main(String[] args) throws Exception {
        /**
         * Non Func // Non Stream // non Lambda code traditionalcode.
         */
        BufferedReader reader = new BufferedReader(new FileReader("d:\\airportsdata\\airports.csv"));
        String data = "";
        List resultList = new ArrayList();
        int counter = 0;
        while ((data = reader.readLine()) != null) {
            if (counter == 0) {
                counter = counter + 1;
                continue;
            }
            String[] cols = data.split(",");
            if (cols[2].equals("\"heliport\"")) {
                resultList.add(cols);
            }
        }


        System.out.println(Files.readAllLines(Paths.get("d:\\airportsdata\\airports.csv")).stream().skip(1).count());
        List<String[]> helipads = Files.readAllLines(Paths.get("d:\\airportsdata\\airports.csv")).
                stream().
                skip(1).
                map(AirportsFunctionDemo::transformByComma).
                filter(AirportsFunctionDemo::findHeliPorts).
                collect(Collectors.toList());

        List<String[]> smap = Files.readAllLines(Paths.get("d:\\airportsdata\\airports.csv")).
                stream().
                skip(1).
                map(AirportsFunctionDemo::transformByComma).
                filter(AirportsFunctionDemo::findSmallAirports).
                collect(Collectors.toList());

        List<String[]> lgap = Files.readAllLines(Paths.get("d:\\airportsdata\\airports.csv")).
                stream().
                skip(1).
                map(AirportsFunctionDemo::transformByComma).
                filter(AirportsFunctionDemo::findLargeAirports).
                collect(Collectors.toList());

        List<String[]> medap = Files.readAllLines(Paths.get("d:\\airportsdata\\airports.csv")).
                stream().
                skip(1).
                map(AirportsFunctionDemo::transformByComma).
                filter(AirportsFunctionDemo::findMediumAirport).
                collect(Collectors.toList());

        List<String[]> closed = Files.readAllLines(Paths.get("d:\\airportsdata\\airports.csv")).
                stream().
                skip(1).
                map(AirportsFunctionDemo::transformByComma).
                filter(AirportsFunctionDemo::findClosedAirports).
                collect(Collectors.toList());

        List<String[]> baloonports = Files.readAllLines(Paths.get("d:\\airportsdata\\airports.csv")).
                stream().
                skip(1).
                map(AirportsFunctionDemo::transformByComma).
                filter(AirportsFunctionDemo::findBallonPort).
                collect(Collectors.toList());

        List<String[]> seaplaneBase = Files.readAllLines(Paths.get("d:\\airportsdata\\airports.csv")).
                stream().
                skip(1).
                map(AirportsFunctionDemo::transformByComma).
                filter(AirportsFunctionDemo::findSeaplaneBase).
                collect(Collectors.toList());

        System.out.println(smap.size());
        System.out.println(lgap.size());
        System.out.println(helipads.size());
        System.out.println(medap.size());
        System.out.println(closed.size());
        System.out.println(baloonports.size());
        System.out.println(seaplaneBase.size());
    }

    public static String[] transformByComma(String data) {
        return data.split(",");
    }

    public static boolean findHeliPorts(String[] data) {
        return data[2].equals("\"heliport\"");
    }

    public static boolean findLargeAirports(String[] data) {
        return data[2].equals("\"large_airport\"");
    }

    public static boolean findSmallAirports(String[] data) {
        return data[2].equals("\"small_airport\"");
    }

    public static boolean findMediumAirport(String[] data) {
        return data[2].equals("\"medium_airport\"");
    }

    public static boolean findClosedAirports(String[] data) {
        return data[2].equals("\"closed\"");
    }


    public static boolean findBallonPort(String[] data) {
        return data[2].equals("\"balloonport\"");
    }

    public static boolean findSeaplaneBase(String[] data) {
        return data[2].equals("\"seaplane_base\"");
    }

}
