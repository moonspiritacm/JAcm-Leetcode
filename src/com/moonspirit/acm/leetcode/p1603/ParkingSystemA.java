package com.moonspirit.acm.leetcode.p1603;

/**
 * 成员变量。O(1) O(1)
 */
class ParkingSystemA {
    private int[] nums;

    public ParkingSystemA(int big, int medium, int small) {
        nums = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (nums[carType - 1] > 0) {
            nums[carType - 1]--;
            return true;
        }
        return false;
    }
}
