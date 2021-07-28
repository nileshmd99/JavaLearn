package com.db.lambdafunctions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class LambdaDemo {

    public static void main(String[] args) {

        List<String> l = new ArrayList<String>();
        Iterator<String> it = l.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        l.forEach((each) -> System.out.println(each));
    }

    public static void readData() {

    }


    public static void xyz(Consumer<?> consumer) {
    }
}

