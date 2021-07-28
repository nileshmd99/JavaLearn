package com.db.collections;

import java.util.*;

/**
 * ADS (Abstract DataStructures)
 * java.util. Package
 * java.util.Collection
 * java.util.List
 * java.util.Set
 * java.util.Map
 * java.util.Queue
 */
public class CollectionExample1 {

    public static void main(String[] args) {
//        testLists();
//        testSet();
        testMap();
    }

    /**
     * // list are growable arrays
     * // List are indexed and maintain sequence
     * // List allow duplicates
     * // List is interface which has many impplementation
     * // List a collection of objects
     * // List from java.util.List
     */
    public static void testLists() {
        List list = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            list.add("xxxxx");
            list.add(1L);
            list.add(2D);
            System.out.println(list.size());
        }
        list.clear();
        List<String> name = new ArrayList<String>();
        name.add("Nilesh");
        System.out.println(name.get(0));
    }

    /**
     * Non INdexed
     * Does not support duplicates
     * Sequience is not guranted but unique is guranteed
     */
    public static void testSet() {
        Set set = new HashSet();
        set.add("Nilesh");
        set.add("Nilesh1");
        set.add("Nilesh2");
        set.add("Nilesh3");
        set.add("Nilesh4");
        System.out.println(set.size());
    }

    /**
     * Collection name value key pair
     * key = value
     * key = value
     * The key is unique and does not allow duplicate
     * The value can be duplicate
     * A Map can have any collection of Map als as it key as well as  values
     */
    public static void testMap() {
        Map<String, String> users = new HashMap<String, String>();
        users.put("user1", "xxxxx");
        users.put("user2", "users2");
        System.out.println(users.get("user1"));

    }


}



