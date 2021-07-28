package com.db.lambdafunctions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaFunctionExamples {


    /**
     * Functional and Streaming api
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            list.add("xxxx" + i);
        }
        System.out.println(list);
        List xx = list.stream().filter(LambdaFunctionExamples::filterData).collect(Collectors.toList());
        System.out.println(xx);

    }


    public static boolean filterData(String each) {
        return each.endsWith("0");
    }
}
