package org.example.data.query;

import java.util.HashMap;
import java.util.Map;

public class PointingMap {

    public static Map<Integer, Integer> getClassic(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2,6);
        map.put(3,4);
        map.put(4,3);
        map.put(5,2);
        map.put(6,1);
        return map;
    }

    public static Map<Integer, Integer> getModern(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2,8);
        map.put(3,6);
        map.put(4,5);
        map.put(5,4);
        map.put(6,3);
        map.put(7,2);
        map.put(8,1);
        return map;
    }

    public static Map<Integer, Integer> getNew(){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,25);
        map.put(2,18);
        map.put(3,15);
        map.put(4,12);
        map.put(5,10);
        map.put(6,8);
        map.put(7,6);
        map.put(8,4);
        map.put(9,2);
        map.put(10,1);
        return map;
    }

    public static Map<Integer, Integer> getPresent(){
        Map<Integer, Integer> map = PointingMap.getNew();
        map.put(0,1); //the record with the fastest round is stored with position 0
        return map;
    }
}
