package com.moonspirit.acm.leetcode.p1603;

/**
 * 二进制分段。O(1) O(1)
 */
class ParkingSystemC {
    private static final int MASK = (1 << 10) - 1;  // 0x000003FF
    private int cnt;

    public ParkingSystemC(int big, int medium, int small) {
        cnt |= big;
        cnt |= medium << 10;
        cnt |= small << 20;
    }

    public boolean addCar(int carType) {
        int num = getCount(carType);
        if (num > 0) {
            setCount(carType, num - 1);
            return true;
        }
        return false;
    }

    private int getCount(int carType) {
        int offset = --carType * 10;
        return cnt >> offset & MASK;
    }

    private void setCount(int carType, int num) {
        int offset = --carType * 10;
        cnt &= ~(MASK << offset);
        cnt |= num << offset;
    }
}
