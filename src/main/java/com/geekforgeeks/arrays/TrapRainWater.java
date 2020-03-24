package com.geekforgeeks.arrays;

public class TrapRainWater {

    public static int trapRainWater(int a[]) {

        int minUnit = ((a[0] < a[a.length - 1]) ? a[0] : a[a.length - 1]);
        int maxUnits = (a.length - 2) * minUnit;

        for (int i = 1; i < a.length - 1; i++) {
            maxUnits = maxUnits - a[i];
        }
        return (maxUnits < 0)?0 : maxUnits;
    }

    public static void main(String args[]) {
        // int a[] = {3, 0, 1, 2, 5};
        int a[] = {5, 0, 6, 2, 3};

        System.out.println(trapRainWater(a));
    }
}
