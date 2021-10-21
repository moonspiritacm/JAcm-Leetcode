package com.moonspirit.acm.leetcode.p1603;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。O(1) O(1)
 */
class ParkingSystemB {
    Map<Integer, Integer> map;

    public ParkingSystemB(int big, int medium, int small) {
        map = new HashMap<>();
        map.put(1, big);
        map.put(2, medium);
        map.put(3, small);
    }

    public boolean addCar(int carType) {
        if (map.get(carType) > 0) {
            map.put(carType, map.get(carType) - 1);
            return true;
        }
        return false;
    }
}
